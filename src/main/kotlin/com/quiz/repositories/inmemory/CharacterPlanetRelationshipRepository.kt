package com.quiz.repositories.inmemory

import com.quiz.repositories.CharacterPlanetRelationshipRepository
import jakarta.inject.Singleton

@Singleton
class InMemoryCharacterPlanetRelationshipRepository : CharacterPlanetRelationshipRepository {
    private val charactersByPlanet = mutableMapOf<Long, MutableSet<Long>>()

    override fun findCharactersBy(planetId: Long): Set<Long> {
        return findInhabitantsSet(planetId)
    }

    override fun addCharacterToPlanet(characterId: Long, planetId: Long) {
        findInhabitantsSet(planetId).add(characterId)
    }

    private fun findInhabitantsSet(planetId: Long): MutableSet<Long> {
        if (!charactersByPlanet.containsKey(planetId)) {
            charactersByPlanet[planetId] = mutableSetOf()
        }
        return charactersByPlanet[planetId] ?: mutableSetOf()
    }
}
