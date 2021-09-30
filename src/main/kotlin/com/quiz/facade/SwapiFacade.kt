package com.quiz.facade

import com.fasterxml.jackson.databind.ObjectMapper
import com.quiz.facade.model.SwapiCharacter
import com.quiz.model.Character
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import jakarta.inject.Singleton
import java.util.*
import java.util.stream.IntStream
import kotlin.streams.toList

@Singleton
class SwapiFacade(@Client("https://swapi.dev/api/") val httpClient: HttpClient, val mapper: ObjectMapper) {

    fun getAllCharacters(): List<Character> {
        return IntStream.range(1, TOTAL_CHARACTERS).toList().mapNotNull {
            httpClient.toBlocking().retrieve("/people/$it/", SwapiCharacter::class.java)
        }.map { Character(it.name, it.parsePlanetId(), it.parseStarshipId()) }
    }

    companion object {
        private const val TOTAL_CHARACTERS = 83
    }
}