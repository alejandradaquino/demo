package com.quiz.repositories.inmemory

import com.quiz.builders.StarshipTestBuilder
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InMemoryStarshipRepositoryTest() {
    @Test
    fun `when saving a starship then I can find it`() {

        val repository = InMemoryStarshipRepository()

        val starship = StarshipTestBuilder().build()
        repository.saveStarship(starship)

        Assertions.assertThat(repository.findById(starship.id)).isEqualTo(starship).usingRecursiveComparison()
    }
    @Test
    fun `when ask for existence of not existent starship returns true`() {

        val repository = InMemoryStarshipRepository()

        val starship = StarshipTestBuilder().build()

        Assertions.assertThat(repository.notExists(starship.id)).isTrue
    }

    @Test
    fun `when ask for existence of  existent starship returns false`() {

        val repository = InMemoryStarshipRepository()

        val starship = StarshipTestBuilder().build()
        repository.saveStarship(starship)

        Assertions.assertThat(repository.notExists(starship.id)).isFalse
    }
}