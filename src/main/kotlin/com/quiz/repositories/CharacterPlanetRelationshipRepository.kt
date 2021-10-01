package com.quiz.repositories

interface CharacterPlanetRelationshipRepository {
    fun findCharactersBy(planetId: Long): Set<Long>
    fun addCharacterToPlanet(characterId: Long, planetId: Long)
}
