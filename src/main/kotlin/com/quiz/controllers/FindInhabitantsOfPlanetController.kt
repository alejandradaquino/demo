package com.quiz.controllers

import com.quiz.services.StarshipsService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client

@Controller
class FindInhabitantsOfPlanetController(private val service: StarshipsService) {
    @Get(value = "/planet/{planetName}/inhabitants", produces = [MediaType.APPLICATION_JSON])
    fun findStarshipsByUser(@PathVariable planetName: String) =
        service.findInhabitantsNamesOf(planetName)
}