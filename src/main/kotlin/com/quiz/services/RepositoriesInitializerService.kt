package com.quiz.services

import com.quiz.facade.SwapiFacade
import com.quiz.repositories.*
import jakarta.inject.Singleton

@Singleton
class RepositoriesInitializerService(
    private val characterPlanetRelationshipRepository: CharacterPlanetRelationshipRepository,
    private val charactersRepository: CharactersRepository,
    private val characterStarshipRelationshipRepository: CharacterStarshipRelationshipRepository,
    private val starshipRepository: StarshipRepository,
    private val planetRepository: PlanetRepository,
    private val facade: SwapiFacade
) {

    fun initialize() {
        facade.getAllPlanets().forEach { planetRepository.save(it) }
        facade.getAllCharacters().forEach {
            characterPlanetRelationshipRepository.addCharacterToPlanet(it.id, it.planetId)
            it.starshipIds.forEach { starshipId ->
                characterStarshipRelationshipRepository.addRelation(it.id, starshipId)
                if (starshipRepository.notExists(starshipId)) {
                    starshipRepository.saveStarship(facade.getStarshipById(starshipId))
                }
            }
            charactersRepository.saveCharacter(it)
        }
    }
}