package com.quiz.services

import com.quiz.model.Starship
import com.quiz.repositories.CharacterStarshipRelationshipRepository
import com.quiz.repositories.CharactersRepository
import com.quiz.repositories.StarshipRepository

class StarshipsService(
    private val charactersRepository: CharactersRepository,
    private val characterStarshipRelationship: CharacterStarshipRelationshipRepository,
    private val starshipRepository: StarshipRepository
) {

    fun findStarshipsUsedBy(charactersName: String) = characterStarshipRelationship
        .findStarshipsFor(charactersRepository.findByName(charactersName).id)
        .map { starshipRepository.findById(it) }
}