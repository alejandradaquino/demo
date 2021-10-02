package com.quiz.repositories

import com.quiz.model.CharacterId
import com.quiz.model.PlanetId

interface CharacterPlanetRelationshipRepository {
    fun findCharactersBy(planetId: PlanetId): Set<CharacterId>
    fun addCharacterToPlanet(characterId: CharacterId, planetId: PlanetId)
}
