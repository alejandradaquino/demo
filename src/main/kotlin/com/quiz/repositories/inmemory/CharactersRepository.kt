package com.quiz.repositories.inmemory

import com.quiz.model.Character
import com.quiz.repositories.CharactersRepository
import jakarta.inject.Singleton
import java.lang.RuntimeException

@Singleton
class InMemoryCharactersRepository : CharactersRepository {
    private val characters = mutableSetOf<Character>()

    override fun findByName(charactersName: String): Character {
        return characters.find { it.name == charactersName } ?: throw RuntimeException("Character not found")

    }

    override fun findById(id: Long): Character {
        return characters.find { it.id == id } ?: throw RuntimeException("Character not found")
    }

    override fun saveCharacter(character: Character) {
        characters.add(character)
    }

}
