package com.quiz.repositories.inmemory

import com.quiz.builders.PlanetTestBuilder
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InMemoryPlanetRepositoryTest() {
    @Test
    fun `when saving a planet then I can find it`() {

        val repository = InMemoryPlanetRepository()

        val planet = PlanetTestBuilder().build()
        repository.save(planet)

        Assertions.assertThat(repository.findByName(planet.name)).isEqualTo(planet).usingRecursiveComparison()
    }

}