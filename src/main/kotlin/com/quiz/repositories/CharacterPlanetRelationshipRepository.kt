package com.quiz.repositories

interface CharacterPlanetRelationshipRepository {
    fun findCharactersBy(planetId: Long): List<Long>
}
