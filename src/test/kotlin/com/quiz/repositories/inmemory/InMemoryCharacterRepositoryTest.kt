package com.quiz.repositories.inmemory

import com.quiz.builders.CharacterTestBuilder
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InMemoryCharacterRepositoryTest() {
    @Test
    fun `when saving a character then I can find it`() {

        val repository = InMemoryCharactersRepository()

        val character = CharacterTestBuilder().build()
        repository.saveCharacter(character)

        Assertions.assertThat(repository.findById(character.id)).isEqualTo(character).usingRecursiveComparison()
    }

    @Test
    fun `when saving a character then I can find it by name`() {

        val repository = InMemoryCharactersRepository()

        val character = CharacterTestBuilder().build()
        repository.saveCharacter(character)

        Assertions.assertThat(repository.findByName(character.name)).isEqualTo(character).usingRecursiveComparison()
    }

}