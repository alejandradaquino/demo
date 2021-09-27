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
        val starship = mapper.readValue(File("src/test/resources/DeathStar.json"), Starship::class.java)

        Assertions.assertThat(starship.name).isEqualTo("Death Star")
        Assertions.assertThat(starship.model).isEqualTo("DS-1 Orbital Battle Station")
        Assertions.assertThat(starship.manufacturer)
            .isEqualTo("Imperial Department of Military Research, Sienar Fleet Systems")
        Assertions.assertThat(starship.costInCredits).isEqualTo("1000000000000")
        Assertions.assertThat(starship.length).isEqualTo("120000")
        Assertions.assertThat(starship.maxAtmospheringSpeed).isEqualTo("n/a")
        Assertions.assertThat(starship.crew).isEqualTo("342,953")
        Assertions.assertThat(starship.passengers).isEqualTo("843,342")
        Assertions.assertThat(starship.cargoCapacity).isEqualTo("1000000000000")
        Assertions.assertThat(starship.consumables).isEqualTo("3 years")
        Assertions.assertThat(starship.hyperdriveRating).isEqualTo("4.0")
        Assertions.assertThat(starship.starshipClass).isEqualTo("Deep Space Mobile Battlestation")
        Assertions.assertThat(starship.mglt).isEqualTo("10")
        Assertions.assertThat(starship.pilots).isEmpty()
        Assertions.assertThat(starship.films).contains(
            "https://swapi.dev/api/films/1/"
        )
    }

}