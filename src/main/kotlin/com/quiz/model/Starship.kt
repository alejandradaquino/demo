package com.quiz.model

typealias StarshipId = Long

data class Starship(
    val id: StarshipId,
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val hyperdriveRating: String,
    val mglt: String,
    val starshipClass: String,
    val pilotsIds: List<Long>,
    val films: List<String>
)
