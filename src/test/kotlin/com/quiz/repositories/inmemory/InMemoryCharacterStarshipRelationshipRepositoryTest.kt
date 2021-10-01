package com.quiz.repositories.inmemory

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

        val starshipId: Long = 1
        val characterId: Long = 2
        repository.addRelation(characterId, starshipId)

        Assertions.assertThat(repository.findStarshipsFor(characterId)).containsExactly(starshipId)
    }

    @Test
    fun `when saving more than one citizen then returns it in the set`() {
        val repository = InMemoryCharacterStarshipRelationshipRepository()

        val starship1: Long = 1
        val starship2: Long = 12
        val characterId: Long = 2
        repository.addRelation(characterId, starship1)
        repository.addRelation(characterId, starship2)

        Assertions.assertThat(repository.findStarshipsFor(characterId)).containsExactly(starship1, starship2)
    }

    @Test
    fun `when saving different citizen in differents planets then returns each correctly`() {
        val repository = InMemoryCharacterStarshipRelationshipRepository()

        val starship1: Long = 1
        val starship2: Long = 12
        val character1: Long = 2
        val starship3: Long = 21
        val starship4: Long = 212
        val character2: Long = 22
        repository.addRelation(character1, starship1)
        repository.addRelation(character1, starship2)
        repository.addRelation(character2, starship3)
        repository.addRelation(character2, starship4)


        Assertions.assertThat(repository.findStarshipsFor(character1)).containsExactly(starship1, starship2)
        Assertions.assertThat(repository.findStarshipsFor(character2)).containsExactly(starship3, starship4)
    }
}