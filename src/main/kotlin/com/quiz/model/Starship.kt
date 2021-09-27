package com.quiz.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(
    PropertyNamingStrategies.SnakeCaseStrategy::class
)
data class Starship(
    var name: String,
    var model: String,
    var manufacturer: String,
    var costInCredits: String,
    var length: String,
    var maxAtmospheringSpeed: String,
    var crew: String,
    var passengers: String,
    var cargoCapacity: String,
    var consumables: String,
    var hyperdriveRating: String,
    var mglt: String,
    var starshipClass: String,
    var pilotsIds: List<Long>,
    var films: List<String>
)
