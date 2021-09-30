package com.quiz.facade.model

import com.quiz.model.Planet

class SwapiPlanet {
    fun toModel(id: Long) = Planet(id, name)

    lateinit var name: String
}