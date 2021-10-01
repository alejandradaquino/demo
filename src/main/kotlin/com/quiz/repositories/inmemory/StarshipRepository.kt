package com.quiz.repositories.inmemory

import com.quiz.model.Starship
import com.quiz.repositories.StarshipRepository
import jakarta.inject.Singleton
import java.lang.RuntimeException

@Singleton
class InMemoryStarshipRepository : StarshipRepository {
    private val starships = mutableSetOf<Starship>()


    override fun findById(id: Long): Starship {
        return starships.find { it.id == id } ?: throw RuntimeException("Starship not found")
    }

    override fun saveStarship(starship: Starship) {
        starships.add(starship)
    }

    override fun notExists(starshipId: Long): Boolean {
        return starships.all { it.id != starshipId }
    }

}
