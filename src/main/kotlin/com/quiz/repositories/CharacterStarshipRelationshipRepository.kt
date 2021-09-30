package com.quiz.repositories

import com.quiz.model.Starship
import java.lang.RuntimeException

class CharacterStarshipRelationshipRepository {
    fun findStarshipsFor(id: Long): List<Long> {
        throw RuntimeException("Implement me")
    }

}
