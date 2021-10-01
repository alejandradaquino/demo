package com.quiz.services

import com.quiz.facade.SwapiFacade
import com.quiz.repositories.CharacterPlanetRelationshipRepository
import com.quiz.repositories.CharacterStarshipRelationshipRepository
import com.quiz.repositories.CharactersRepository
import com.quiz.repositories.StarshipRepository
import jakarta.inject.Singleton

@Singleton
class RepositoriesInitializerService(
    val characterPlanetRelationshipRepository: CharacterPlanetRelationshipRepository,
    val charactersRepository: CharactersRepository,
    val characterStarshipRelationshipRepository: CharacterStarshipRelationshipRepository,
    val starshipRepository: StarshipRepository,
    val facade: SwapiFacade
) {

    fun initialize() {


    }
}