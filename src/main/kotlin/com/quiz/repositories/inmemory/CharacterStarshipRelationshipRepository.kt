package com.quiz.repositories.inmemory

import com.quiz.repositories.CharacterStarshipRelationshipRepository
import jakarta.inject.Singleton

@Singleton
class InMemoryCharacterStarshipRelationshipRepository : CharacterStarshipRelationshipRepository {
    private val starshipsByCharacter = mutableMapOf<Long, MutableSet<Long>>()
    override fun findStarshipsFor(id: Long): Set<Long> {
        return findSet(id)
    }

    override fun addRelation(characterId: Long, starshipId: Long) {
        findSet(characterId).add(starshipId)
    }

    private fun findSet(characterId: Long): MutableSet<Long> {
        if (!starshipsByCharacter.containsKey(characterId)) {
            starshipsByCharacter[characterId] = mutableSetOf()
        }
        return starshipsByCharacter[characterId] ?: mutableSetOf()
    }
}
