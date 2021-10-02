package com.quiz.repositories.inmemory

import com.quiz.exceptions.ResourceNotFoundException
import com.quiz.model.Character
import com.quiz.model.CharacterId
import com.quiz.repositories.CharactersRepository
import jakarta.inject.Singleton
import java.lang.RuntimeException

@Singleton
class InMemoryCharactersRepository : CharactersRepository {
    private val characters = mutableSetOf<Character>()

    override fun findByName(charactersName: String): Character {
        return characters.find { it.name == charactersName }
            ?: throw ResourceNotFoundException("Character $charactersName not found")

    }

    override fun findById(id: CharacterId): Character {
        return characters.find { it.id == id } ?: throw ResourceNotFoundException("Character with id $id not found")
    }

    override fun saveCharacter(character: Character) {
        characters.add(character)
    }

}
