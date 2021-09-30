package com.quiz.repositories

import com.quiz.model.Planet
import java.lang.RuntimeException

class PlanetRepository {
    fun findByName(name: String): Planet {
        throw RuntimeException("Implement me")
    }

}
