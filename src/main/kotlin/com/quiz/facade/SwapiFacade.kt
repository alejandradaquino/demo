package com.quiz.facade

import com.quiz.facade.model.SwapiCharacter
import com.quiz.facade.model.SwapiPlanet
import com.quiz.facade.model.SwapiStarship
import com.quiz.model.Character
import com.quiz.model.Planet
import com.quiz.model.Starship
import com.quiz.services.StarshipsService
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory
import java.lang.Exception
import java.util.stream.IntStream
import java.util.stream.IntStream.range
import kotlin.streams.toList

@Singleton
class SwapiFacade(@Client("https://swapi.dev/api/") val httpClient: HttpClient) {

    val logger = LoggerFactory.getLogger(SwapiFacade::class.java)
    fun getAllCharacters(): List<Character> {
        return range(1, TOTAL_CHARACTERS).toLong().mapNotNull {
            try {
                httpClient.toBlocking().retrieve("/people/$it/", SwapiCharacter::class.java).toModel(it)
            } catch (error: Exception) {
                logger.warn("Exception finding people with id: $it", error)
                null
            }
        }
    }

    fun getAllPlanets(): List<Planet> {
        return range(1, TOTAL_PLANETS).toLong().mapNotNull {
            try {
                httpClient.toBlocking().retrieve("/planets/$it/", SwapiPlanet::class.java).toModel(it)
            } catch (error: Exception) {
                logger.warn("Exception finding planet with id: $it", error)
                null
            }
        }
    }


    fun getStarshipById(id: Long): Starship {
        return httpClient.toBlocking().retrieve("/starships/$id/", SwapiStarship::class.java).toModel(id)
    }

    companion object {
        private const val TOTAL_CHARACTERS = 83
        private const val TOTAL_PLANETS = 59
    }
}

private fun IntStream.toLong() = this.toList().map { it.toLong() }
