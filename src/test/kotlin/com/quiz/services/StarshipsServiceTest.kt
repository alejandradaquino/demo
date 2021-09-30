package com.quiz.services

import com.quiz.builders.CharacterTestBuilder
import com.quiz.builders.StarshipTestBuilder
import com.quiz.model.Character
import com.quiz.repositories.CharacterStarshipRelationshipRepository
import com.quiz.repositories.CharactersRepository
import com.quiz.repositories.StarshipRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
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
    val character = CharacterTestBuilder().build()
    val starship11 = StarshipTestBuilder().withId(11).build()
    val starship12 = StarshipTestBuilder().withId(12).build()
    val starship13 = StarshipTestBuilder().withId(13).build()
    lateinit var service: StarshipsService

    @BeforeEach
    fun setUp() {
        service = StarshipsService(charactersRepository, characterStarshipRelationship, starshipRepository)
        `when`(starshipRepository.findById(11)).thenReturn(starship11)
        `when`(starshipRepository.findById(12)).thenReturn(starship12)
        `when`(charactersRepository.findByName(character.name)).thenReturn(character)
    }


    @Test
    fun `when ask for starships of a characters it search realtion and get response`() {
        givenCharacterHasRelationWith11and12()

        val findStarshipsUsedBy = service.findStarshipsUsedBy(character.name)

        Assertions.assertThat(findStarshipsUsedBy).containsExactly(starship11, starship12)
    }

    private fun givenCharacterHasRelationWith11and12() {
        `when`(characterStarshipRelationship.findStarshipsFor(character.id)).thenReturn(
            listOf(starship11.id, starship12.id)
        )
    }
}