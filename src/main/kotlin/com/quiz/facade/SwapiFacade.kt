package com.quiz.facade

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import jakarta.inject.Singleton

@Singleton
class SwapiFacade(@Client("https://swapi.dev/api/") val httpClient: HttpClient) {
    fun bla(): String {

        val result: String = httpClient.toBlocking().retrieve("/people/1/")
        return "$result"
    }
}