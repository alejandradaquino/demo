package com.quiz.services

import com.quiz.builders.CharacterTestBuilder
import com.quiz.builders.PlanetTestBuilder
import com.quiz.builders.StarshipTestBuilder
import com.quiz.repositories.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class StarshipsServiceTest() {
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

    @InjectMocks
    private lateinit var service: StarshipsService

    val character1 = CharacterTestBuilder().withId(1).build()

    val character2 = CharacterTestBuilder().withId(1).build()
    val character3 = CharacterTestBuilder().withId(1).build()

    val starship11 = StarshipTestBuilder().withId(11).build()
    val starship12 = StarshipTestBuilder().withId(12).build()

    val planet = PlanetTestBuilder().build()

    @Test
    fun `when ask for starships of a characters it search realtion and get response`() {
        givenCharacterHasRelationWith11and12()

        val findStarshipsUsedBy = service.findStarshipsUsedBy(character1.name)

        Assertions.assertThat(findStarshipsUsedBy).containsExactly(starship11, starship12)
    }

    @Test
    fun `when ask for inhabitants of a planet it search relation and get response`() {
        `when`(planetRepository.findByName(planet.name)).thenReturn(planet)
        `when`(charactersRepository.findById(character2.id)).thenReturn(character1)
        `when`(charactersRepository.findById(character3.id)).thenReturn(character3)
        `when`(charactersPlanetRelationship.findCharactersBy(planet.id)).thenReturn(
            setOf(character2.id, character3.id)
        )

        val inhabitants = service.findInhabitantsNamesOf(planet.name)

        Assertions.assertThat(inhabitants).containsExactly(character2.name, character3.name)
    }

    private fun givenCharacterHasRelationWith11and12() {
        `when`(charactersRepository.findByName(character1.name)).thenReturn(character1)
        `when`(starshipRepository.findById(11)).thenReturn(starship11)
        `when`(starshipRepository.findById(12)).thenReturn(starship12)
        `when`(characterStarshipRelationship.findStarshipsFor(character1.id)).thenReturn(
            listOf(starship11.id, starship12.id)
        )
    }
}