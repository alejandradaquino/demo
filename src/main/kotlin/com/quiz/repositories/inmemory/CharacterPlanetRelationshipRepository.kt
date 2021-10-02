package com.quiz.repositories.inmemory

import com.quiz.model.CharacterId
import com.quiz.model.PlanetId
import com.quiz.repositories.CharacterPlanetRelationshipRepository
import jakarta.inject.Singleton

@Singleton
class InMemoryCharacterPlanetRelationshipRepository : CharacterPlanetRelationshipRepository {
    private val charactersByPlanet = mutableMapOf<PlanetId, MutableSet<CharacterId>>()

    override fun findCharactersBy(planetId: PlanetId): Set<CharacterId> {
        return findInhabitantsSet(planetId)
    }

    override fun addCharacterToPlanet(characterId: CharacterId, planetId: PlanetId) {
        findInhabitantsSet(planetId).add(characterId)
    }

    private fun findInhabitantsSet(planetId: PlanetId): MutableSet<CharacterId> {
        if (!charactersByPlanet.containsKey(planetId)) {
            charactersByPlanet[planetId] = mutableSetOf()
        }
        return charactersByPlanet[planetId] ?: mutableSetOf()
    }
}
