package com.quiz.configurations

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class BeanFactory {
    @Singleton
    fun mapper(): ObjectMapper {
        return ObjectMapper()
    }
}