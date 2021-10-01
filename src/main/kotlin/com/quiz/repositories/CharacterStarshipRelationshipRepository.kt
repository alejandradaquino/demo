package com.quiz.repositories

interface CharacterStarshipRelationshipRepository {
    fun findStarshipsFor(id: Long): Set<Long>
    fun addRelation(starshipId: Long, id: Long)
}
