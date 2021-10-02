package com.quiz.builders

import com.quiz.model.Character
import com.quiz.model.CharacterId

class CharacterTestBuilder {
    private var id: CharacterId = 2
    private var name: String = Math.random().toString()
    private var planetId: Long = 23L
    private var starshipIds: List<Long> = listOf(33, 44, 24, 2)

    fun build() = Character(id, name, planetId, starshipIds)
    fun withId(id: Long): CharacterTestBuilder {
        this.id = id
        return this
    }

    fun withStarships(starshipId: List<Long>): CharacterTestBuilder {
        this.starshipIds = starshipId
        return this
    }

    fun withPlanet(planetId: Long): CharacterTestBuilder {
        this.planetId = planetId
        return this
    }
}