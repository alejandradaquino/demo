package com.quiz.repositories.inmemory

import com.quiz.model.CharacterId
import com.quiz.model.Planet
import com.quiz.model.PlanetId
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InMemoryCharacterPlanetRelationshipRepositoryTest() {
    @Test
    fun `when no inhabitants then returns it in the empty set`() {
        val repository = InMemoryCharacterPlanetRelationshipRepository()

        val planetId: Long = 2

        Assertions.assertThat(repository.findCharactersBy(planetId)).isEmpty()
    }

    @Test
    fun `when saving a relationship then returns it in the set`() {
        val repository = InMemoryCharacterPlanetRelationshipRepository()

        val characterId: CharacterId = 1
        val planetId: PlanetId = 2
        repository.addCharacterToPlanet(characterId, planetId)

        Assertions.assertThat(repository.findCharactersBy(planetId)).containsExactly(characterId)
    }

    @Test
    fun `when saving more than one citizen then returns it in the set`() {
        val repository = InMemoryCharacterPlanetRelationshipRepository()

        val characterId: CharacterId = 1
        val characterId2: CharacterId = 12
        val planetId: PlanetId = 2
        repository.addCharacterToPlanet(characterId, planetId)
        repository.addCharacterToPlanet(characterId2, planetId)

        Assertions.assertThat(repository.findCharactersBy(planetId)).containsExactly(characterId, characterId2)
    }

    @Test
    fun `when saving different citizen in differents planets then returns each correctly`() {
        val repository = InMemoryCharacterPlanetRelationshipRepository()

        val characterId: CharacterId = 1
        val characterId2: CharacterId = 12
        val planetId: PlanetId = 2
        val characterId3: CharacterId = 21
        val characterId4: CharacterId = 212
        val planetId2: PlanetId = 22
        repository.addCharacterToPlanet(characterId, planetId)
        repository.addCharacterToPlanet(characterId2, planetId)
        repository.addCharacterToPlanet(characterId3, planetId2)
        repository.addCharacterToPlanet(characterId4, planetId2)


        Assertions.assertThat(repository.findCharactersBy(planetId)).containsExactly(characterId, characterId2)
        Assertions.assertThat(repository.findCharactersBy(planetId2)).containsExactly(characterId3, characterId4)
    }
}