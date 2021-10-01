package com.quiz.repositories.inmemory

interface CharacterStarshipRelationshipRepository {
    fun findStarshipsFor(id: Long): List<Long>
    fun addCharacterToStarship(id: Long, starshipId: Long)
}
