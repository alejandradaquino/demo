package com.quiz.repositories

import com.quiz.model.Character
import java.lang.RuntimeException

class CharactersRepository {
    fun findByName(charactersName: String): Character {
        throw RuntimeException("Implement me")
    }

}
