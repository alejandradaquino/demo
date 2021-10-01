package com.quiz.repositories

import com.quiz.model.Character

interface CharactersRepository {
    fun findByName(charactersName: String): Character

    fun findById(it: Long): Character

}
