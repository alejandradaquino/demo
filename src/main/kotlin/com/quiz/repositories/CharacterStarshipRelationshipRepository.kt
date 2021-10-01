package com.quiz.repositories

interface CharacterStarshipRelationshipRepository {
    fun findStarshipsFor(id: Long): List<Long>
}
