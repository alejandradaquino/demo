package com.quiz.facade.model

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

@MicronautTest
class StarshipTest() {

    @Inject
    lateinit var mapper: ObjectMapper

    @Test
    fun `when deserialize character fields are ok`() {
        val swapiStarship = mapper.readValue(File("src/test/resources/DeathStar.json"), SwapiStarship::class.java)

        Assertions.assertThat(swapiStarship.name).isEqualTo("Death Star")
        Assertions.assertThat(swapiStarship.model).isEqualTo("DS-1 Orbital Battle Station")
        Assertions.assertThat(swapiStarship.manufacturer)
            .isEqualTo("Imperial Department of Military Research, Sienar Fleet Systems")
        Assertions.assertThat(swapiStarship.costInCredits).isEqualTo("1000000000000")
        Assertions.assertThat(swapiStarship.length).isEqualTo("120000")
        Assertions.assertThat(swapiStarship.maxAtmospheringSpeed).isEqualTo("n/a")
        Assertions.assertThat(swapiStarship.crew).isEqualTo("342,953")
        Assertions.assertThat(swapiStarship.passengers).isEqualTo("843,342")
        Assertions.assertThat(swapiStarship.cargoCapacity).isEqualTo("1000000000000")
        Assertions.assertThat(swapiStarship.consumables).isEqualTo("3 years")
        Assertions.assertThat(swapiStarship.hyperdriveRating).isEqualTo("4.0")
        Assertions.assertThat(swapiStarship.starshipClass).isEqualTo("Deep Space Mobile Battlestation")
        Assertions.assertThat(swapiStarship.mglt).isEqualTo("10")
        Assertions.assertThat(swapiStarship.pilots).isEmpty()
        Assertions.assertThat(swapiStarship.films).contains(
            "https://swapi.dev/api/films/1/"
        )
    }

}