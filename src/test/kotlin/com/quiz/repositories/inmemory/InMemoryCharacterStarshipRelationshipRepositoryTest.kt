package com.quiz.repositories.inmemory

import com.quiz.model.Character
import com.quiz.model.CharacterId
import com.quiz.model.StarshipId
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InMemoryCharacterStarshipRelationshipRepositoryTest() {
    @Test
    fun `when no satships then returns it in the empty set`() {
        val repository = InMemoryCharacterStarshipRelationshipRepository()

        val characterId: Long = 2

        Assertions.assertThat(repository.findStarshipsFor(characterId)).isEmpty()
    }

    @Test
    fun `when saving a relationship then returns it in the set`() {
        val repository = InMemoryCharacterStarshipRelationshipRepository()

        val starshipId: StarshipId = 1
        val characterId: CharacterId = 2
        repository.addRelation(starshipId, characterId)

        Assertions.assertThat(repository.findStarshipsFor(characterId)).containsExactly(starshipId)
    }

    @Test
    fun `when saving more than one citizen then returns it in the set`() {
        val repository = InMemoryCharacterStarshipRelationshipRepository()

        val starship1: StarshipId = 1
        val starship2: StarshipId = 12
        val characterId: CharacterId = 2
        repository.addRelation(starship1, characterId)
        repository.addRelation(starship2, characterId)

        Assertions.assertThat(repository.findStarshipsFor(characterId)).containsExactly(starship1, starship2)
    }

    @Test
    fun `when saving different citizen in differents planets then returns each correctly`() {
        val repository = InMemoryCharacterStarshipRelationshipRepository()

        val starship1: StarshipId = 1
        val starship2: StarshipId = 12
        val character1: CharacterId = 2
        val starship3: StarshipId = 21
        val starship4: StarshipId = 212
        val character2: CharacterId = 22
        repository.addRelation(starship2, character1)
        repository.addRelation(starship1, character1)
        repository.addRelation(starship3, character2)
        repository.addRelation(starship4, character2)


        Assertions.assertThat(repository.findStarshipsFor(character1)).containsOnly(starship1, starship2)
        Assertions.assertThat(repository.findStarshipsFor(character2)).containsOnly(starship3, starship4)
    }
}