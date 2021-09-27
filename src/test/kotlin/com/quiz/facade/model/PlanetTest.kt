package com.quiz.facade.model

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

@MicronautTest
class PlanetTest() {

    @Inject
    lateinit var mapper: ObjectMapper

    @Test
    fun `when deserialize character fields are ok`() {
        val swapiPlanet = mapper.readValue(File("src/test/resources/Planet.json"), SwapiPlanet::class.java)

        Assertions.assertThat(swapiPlanet.name).isEqualTo("Yavin IV")
    }
}