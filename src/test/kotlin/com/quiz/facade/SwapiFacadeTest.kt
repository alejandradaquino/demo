package com.quiz.facade

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.quiz.facade.model.SwapiCharacter
import com.quiz.facade.model.SwapiPlanet
import com.quiz.facade.model.SwapiStarship
import com.quiz.model.Starship
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.io.File

@ExtendWith(MockitoExtension::class)
class SwapiFacadeTest() {
    @Mock
    private lateinit var blocking: BlockingHttpClient

    @Mock
    lateinit var httpClient: HttpClient

    private val mapper = ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    @BeforeEach
    fun setUp() {
        doReturn(blocking).`when`(httpClient).toBlocking();
        val luke = mapper.readValue(File("src/test/resources/Luke.json"), SwapiCharacter::class.java)
        val planet = mapper.readValue(File("src/test/resources/Planet.json"), SwapiPlanet::class.java)
        val deathStar = mapper.readValue(File("src/test/resources/DeathStar.json"), SwapiStarship::class.java)

        doAnswer {
            val url = it.arguments[0] as String
            if (url.startsWith("/people/")) luke
            else if (url.startsWith("/planets/")) planet
            else deathStar
        }.`when`(blocking).retrieve(anyString(), any(Class::class.java))
    }

    @Test
    fun `when calling facade then make a request for each character`() {

        assertThat(httpClient).isNotNull

        val characters = SwapiFacade(httpClient).getAllCharacters()

        assertThat(characters).hasSize(82)
        assertThat(characters[0].name).isEqualTo("Luke Skywalker")
    }

    @Test
    fun `when calling facade then make a request for each planet`() {

        assertThat(httpClient).isNotNull

        val planets = SwapiFacade(httpClient).getAllPlanets()

        assertThat(planets).hasSize(58)
        assertThat(planets[0].name).isEqualTo("Yavin IV")
    }

    @Test
    fun `when calling facade then make a request for a starship then returns the starship`() {

        assertThat(httpClient).isNotNull

        val starship = SwapiFacade(httpClient).getStarshipById(1L)

        assertThat(starship).isNotNull
        assertThat(starship.name).isEqualTo("Death Star")
    }

}