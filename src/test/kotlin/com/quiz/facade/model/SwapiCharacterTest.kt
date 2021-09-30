package com.quiz.facade.model

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

@MicronautTest
class SwapiCharacterTest() {

    @Inject
    lateinit var mapper: ObjectMapper

    @Test
    fun `when deserialize character fields are ok`() {
        val character = mapper.readValue(File("src/test/resources/Luke.json"), SwapiCharacter::class.java)

        assertThat(character.name).isEqualTo("Luke Skywalker")
        assertThat(character.homeworld).isEqualTo("https://swapi.dev/api/planets/1/")
        assertThat(character.starships).contains(
            "https://swapi.dev/api/starships/12/",
            "https://swapi.dev/api/starships/22/"
        )
        assertThat(character.parseStarshipId()).contains(12, 22)
    }

}