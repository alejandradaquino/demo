package com.quiz.repositories

import com.quiz.model.CharacterId
import com.quiz.model.StarshipId


interface CharacterStarshipRelationshipRepository {
    fun findStarshipsFor(characterId: CharacterId): Set<StarshipId>
    fun addRelation(starshipId: StarshipId, characterId: CharacterId)
}
