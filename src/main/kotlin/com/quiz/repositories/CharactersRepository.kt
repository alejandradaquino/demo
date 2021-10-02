package com.quiz.repositories

import com.quiz.model.Character
import com.quiz.model.CharacterId

interface CharactersRepository {
    fun findByName(charactersName: String): Character
    fun findById(it: CharacterId): Character
    fun saveCharacter(it: Character)

}
