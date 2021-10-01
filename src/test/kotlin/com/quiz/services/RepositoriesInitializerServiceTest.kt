package com.quiz.services

import com.quiz.builders.CharacterTestBuilder
import com.quiz.builders.PlanetTestBuilder
import com.quiz.builders.StarshipTestBuilder
import com.quiz.facade.SwapiFacade
import com.quiz.model.Character
import com.quiz.model.Planet
import com.quiz.model.Starship
import com.quiz.repositories.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class RepositoriesInitializerServiceTest() {

    @Mock
    private lateinit var starshipRepository: StarshipRepository

    @Mock
    private lateinit var characterStarshipRelationship: CharacterStarshipRelationshipRepository

    @Mock
    private lateinit var charactersRepository: CharactersRepository

    @Mock
    private lateinit var planetRepository: PlanetRepository

    @Mock
    private lateinit var charactersPlanetRelationship: CharacterPlanetRelationshipRepository


    @Mock
    private lateinit var facade: SwapiFacade

    @InjectMocks
    private lateinit var service: RepositoriesInitializerService

    @Captor
    lateinit var planetIdCaptor: ArgumentCaptor<Long>

    @Captor
    lateinit var starshipIdCaptor: ArgumentCaptor<Long>

    @Captor
    lateinit var characterIdCaptor: ArgumentCaptor<Long>

    @Captor
    lateinit var characterCaptor: ArgumentCaptor<Character>

    @Captor
    lateinit var planetCaptor: ArgumentCaptor<Planet>


    @Captor
    lateinit var starshipCaptor: ArgumentCaptor<Starship>

    private val planet = PlanetTestBuilder().withId(23).build()

    private val starship = StarshipTestBuilder().withId(10).build()

    @BeforeEach
    fun setUp() {
        doReturn(listOf(planet)).`when`(facade).getAllPlanets()
    }

    @Test
    fun `with no characters no repository is called`() {
        `when`(facade.getAllCharacters()).thenReturn(listOf())

        service.initialize()

        thenPlanetIsSaved()
        andNoMoreInteractionsWithRepositories()

    }

    @Test
    fun `with a character with no starships register the planet`() {
        val character = CharacterTestBuilder().withId(12).withPlanet(23).withStarships(emptyList()).build()
        `when`(facade.getAllCharacters()).thenReturn(listOf(character))

        service.initialize()

        thenCharacterIsRegisteredInPlanet()
        andCharacterSavedInRepository(character)
    }

    @Test
    fun `with a character with a non existent starships register the starship and save it`() {
        `when`(facade.getStarshipById(10)).thenReturn(starship)
        `when`(starshipRepository.notExists(10)).thenReturn(true)

        val character = CharacterTestBuilder().withId(12).withPlanet(23).withStarships(listOf(10)).build()
        `when`(facade.getAllCharacters()).thenReturn(listOf(character))

        service.initialize()
        starshipIsSaved()
        relationWithStarshipIsRegistered()

    }

    @Test
    fun `with a character with a  existent starships register the starship and do not save it`() {
        `when`(starshipRepository.notExists(10)).thenReturn(false)

        val character = CharacterTestBuilder().withId(12).withPlanet(23).withStarships(listOf(10)).build()
        `when`(facade.getAllCharacters()).thenReturn(listOf(character))

        service.initialize()
        verifyNoMoreInteractions(starshipRepository)
        relationWithStarshipIsRegistered()

    }

    private fun relationWithStarshipIsRegistered() {
        verify(characterStarshipRelationship).addRelation(
            starshipIdCaptor.capture(),
            characterIdCaptor.capture()
        )
        assertThat(characterIdCaptor.value).isEqualTo(12)
        assertThat(starshipIdCaptor.value).isEqualTo(10)
    }

    private fun starshipIsSaved() {
        verify(starshipRepository).saveStarship(capture(starshipCaptor))
        assertThat(starshipCaptor.value).isEqualTo(starship).usingRecursiveComparison()
    }

    private fun andCharacterSavedInRepository(character: Character) {
        verify(charactersRepository).saveCharacter(capture(characterCaptor))
        assertThat(characterCaptor.value).isEqualTo(character).usingRecursiveComparison()
    }

    private fun thenCharacterIsRegisteredInPlanet() {
        verify(charactersPlanetRelationship).addCharacterToPlanet(characterIdCaptor.capture(), planetIdCaptor.capture())
        assertThat(characterIdCaptor.value).isEqualTo(12)
        assertThat(planetIdCaptor.value).isEqualTo(23)
    }


    private fun andNoMoreInteractionsWithRepositories() {
        verifyNoMoreInteractions(starshipRepository)
        verifyNoMoreInteractions(characterStarshipRelationship)
        verifyNoMoreInteractions(charactersRepository)
        verifyNoMoreInteractions(planetRepository)
        verifyNoMoreInteractions(charactersPlanetRelationship)
    }

    private fun thenPlanetIsSaved() {
        verify(planetRepository).save(capture(planetCaptor))
        assertThat(planetCaptor.value).isEqualTo(planet).usingRecursiveComparison()
    }

}

fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()