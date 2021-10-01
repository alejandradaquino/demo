package com.quiz.repositories.inmemory

import com.quiz.model.Character
import com.quiz.model.Planet
import com.quiz.repositories.PlanetRepository
import java.lang.RuntimeException

class InMemoryPlanetRepository : PlanetRepository {
    private val planets = mutableSetOf<Planet>()

    override fun findByName(name: String): Planet {
        return planets.find { it.name == name } ?: throw RuntimeException("Planet not found")
    }

    override fun save(it: Planet) {
        planets.add(it)
    }
}
