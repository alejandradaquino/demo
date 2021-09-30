package com.quiz.builders

import com.quiz.model.Character

class CharacterTestBuilder {
    var id: Long = 2
    var name: String = "ale"
    var planetId: Long = 23L
    var starshipIds: List<Long> = listOf(33, 44, 24, 2)

    fun build() = Character(id, name, planetId, starshipIds)
}