package com.quiz.controllers

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client

@Controller("/hello")
class HelloController() {
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return ""
    }
}