package com.quiz.builders

import com.quiz.model.Character
import com.quiz.model.Planet

class PlanetTestBuilder {
    var id: Long = 2
    var name: String = "somePlanet"

    fun build() = Planet(id, name)
    fun withId(id: Long): PlanetTestBuilder {
        this.id = id
        return this
    }
}