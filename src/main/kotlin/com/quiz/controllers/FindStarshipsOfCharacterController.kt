package com.quiz.controllers

import com.quiz.services.StarshipsService
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.hateoas.JsonError
import io.micronaut.http.hateoas.Link

@Controller
class FindStarshipsOfCharacterController(private val service: StarshipsService) {
    @Get(value = "/character/{characterName}/starships", produces = [MediaType.APPLICATION_JSON])
    fun findStarshipsByUser(@PathVariable characterName: String) =
        service.findStarshipsUsedBy(characterName)


}