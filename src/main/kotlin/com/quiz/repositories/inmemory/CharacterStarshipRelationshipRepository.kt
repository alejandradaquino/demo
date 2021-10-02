package com.quiz.repositories.inmemory

import com.quiz.model.CharacterId
import com.quiz.model.StarshipId
import com.quiz.repositories.CharacterStarshipRelationshipRepository
import jakarta.inject.Singleton


@Singleton
class InMemoryCharacterStarshipRelationshipRepository : CharacterStarshipRelationshipRepository {
    private val starshipsByCharacter = mutableMapOf<CharacterId, MutableSet<StarshipId>>()
    override fun findStarshipsFor(id: CharacterId): Set<StarshipId> {
        return findSet(id)
    }

    override fun addRelation(starshipId: StarshipId, characterId: CharacterId) {
        findSet(characterId).add(starshipId)
    }

    private fun findSet(characterId: CharacterId): MutableSet<StarshipId> {
        if (!starshipsByCharacter.containsKey(characterId)) {
            starshipsByCharacter[characterId] = mutableSetOf()
        }
        return starshipsByCharacter[characterId] ?: mutableSetOf()
    }
}
