package com.quiz.model


typealias CharacterId = Long

data class Character(var id: CharacterId, var name: String, var planetId: Long, var starshipIds: List<StarshipId>)