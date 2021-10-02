package com.quiz.controllers

import com.quiz.exceptions.ResourceNotFoundException
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.hateoas.JsonError
import io.micronaut.http.hateoas.Link

@Controller
class ErrorHandler {
    @Error(global = true)
    fun error(request: HttpRequest<*>, e: Throwable): HttpResponse<JsonError> {
        if (e is ResourceNotFoundException) {
            return HttpResponse.notFound(JsonError(e.message))
        }

        return HttpResponse.serverError<JsonError>()
            .body(
                JsonError("Bad Things Happened: ${e.message}")
                    .link(Link.SELF, Link.of(request.uri))
            )
    }
}