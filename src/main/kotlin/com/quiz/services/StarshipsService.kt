package com.quiz.services

import com.quiz.repositories.*

class StarshipsService(
    private val charactersRepository: CharactersRepository,
    private val characterStarshipRelationship: CharacterStarshipRelationshipRepository,
    private val starshipRepository: StarshipRepository,
    val planetRepository: PlanetRepository,
    val charactersPlanetRelationship: CharacterPlanetRelationshipRepository
) {

    fun findStarshipsUsedBy(charactersName: String) = characterStarshipRelationship
        .findStarshipsFor(charactersRepository.findByName(charactersName).id)
        .map { starshipRepository.findById(it) }

    fun findInhabitantsNamesOf(planet: String): List<String> {
        val characters = charactersPlanetRelationship.findCharactersBy(
            planetRepository.findByName(planet).id
        )
        return characters
            .map { charactersRepository.findById(it) }
            .map { it.name }
    }
}