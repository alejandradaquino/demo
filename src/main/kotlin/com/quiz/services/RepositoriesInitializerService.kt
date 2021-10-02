package com.quiz.services

import com.quiz.facade.SwapiFacade
import com.quiz.repositories.*
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class RepositoriesInitializerService(
    private val characterPlanetRelationshipRepository: CharacterPlanetRelationshipRepository,
    private val charactersRepository: CharactersRepository,
    private val characterStarshipRelationshipRepository: CharacterStarshipRelationshipRepository,
    private val starshipRepository: StarshipRepository,
    private val planetRepository: PlanetRepository,
    private val facade: SwapiFacade
) {

    val logger = LoggerFactory.getLogger(RepositoriesInitializerService::class.java)
    fun initialize() {
        logger.info("Starting initializer: Planets")
        facade.getAllPlanets().forEach { planetRepository.save(it) }
        logger.info("Planets completed")
        facade.getAllCharacters().forEach {
            logger.info("Updating info of charactar ${it.name}")
            characterPlanetRelationshipRepository.addCharacterToPlanet(it.id, it.planetId)
            it.starshipIds.forEach { starshipId ->
                characterStarshipRelationshipRepository.addRelation(starshipId, it.id)
                if (starshipRepository.notExists(starshipId)) {
                    logger.info("Saving starship $starshipId")
                    starshipRepository.saveStarship(facade.getStarshipById(starshipId))
                }
            }
            charactersRepository.saveCharacter(it)
        }
    }
}