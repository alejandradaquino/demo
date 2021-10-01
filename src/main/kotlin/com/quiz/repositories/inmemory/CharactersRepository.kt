package com.quiz.repositories.inmemory

import com.quiz.model.Character

interface CharactersRepository {
    fun findByName(charactersName: String): Character
    fun findById(it: Long): Character
    fun saveCharacter(it: Character)

}
