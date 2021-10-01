package com.quiz.facade

import com.quiz.facade.model.SwapiCharacter
import com.quiz.facade.model.SwapiPlanet
import com.quiz.facade.model.SwapiStarship
import com.quiz.model.Character
import com.quiz.model.Planet
import com.quiz.model.Starship
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import jakarta.inject.Singleton
import java.util.stream.IntStream
import java.util.stream.IntStream.range
import kotlin.streams.toList

@Singleton
class SwapiFacade(@Client("https://swapi.dev/api/") val httpClient: HttpClient) {

    fun getAllCharacters(): List<Character> {
        return range(1, TOTAL_CHARACTERS).toLong().map {
            httpClient.toBlocking().retrieve("/people/$it/", SwapiCharacter::class.java).toModel(it)
        }
    }

    fun getAllPlanets(): List<Planet> {
        return range(1, TOTAL_PLANETS).toLong().map {
            httpClient.toBlocking().retrieve("/planet/$it/", SwapiPlanet::class.java).toModel(it)
        }
    }

    fun getStarshipById(id: Long): Starship {
        return httpClient.toBlocking().retrieve("/starships/$id/", SwapiStarship::class.java).toModel(id)
    }

    companion object {
        private const val TOTAL_CHARACTERS = 83
        private const val TOTAL_PLANETS = 60
    }
}

private fun IntStream.toLong() = this.toList().map { it.toLong() }
