package com.quiz.repositories.inmemory

import com.quiz.model.Starship
import com.quiz.repositories.StarshipRepository
import java.lang.RuntimeException

class InMemoryStarshipRepository : StarshipRepository {
    private val planets = mutableSetOf<Starship>()


    override fun findById(id: Long): Starship {
        return planets.find { it.id == id } ?: throw RuntimeException("Starship not found")
    }

    override fun saveStarship(starship: Starship) {
        planets.add(starship)
    }

    override fun notExists(starshipId: Long): Boolean {
        return planets.all { it.id != starshipId }
    }

}
