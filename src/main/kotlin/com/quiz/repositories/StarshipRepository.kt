package com.quiz.repositories

import com.quiz.model.Starship
import java.lang.RuntimeException

class StarshipRepository {
    fun findById(it: Long): Starship {
        throw RuntimeException("Implement me")
    }

}
