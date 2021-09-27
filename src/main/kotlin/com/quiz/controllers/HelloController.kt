package com.quiz.controllers

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client

@Controller("/hello")
class HelloController( @Client("https://swapi.dev/api/") val httpClient: HttpClient ) {
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        val result: String = httpClient.toBlocking().retrieve("/people/1/")
        return "$result"
    }
}