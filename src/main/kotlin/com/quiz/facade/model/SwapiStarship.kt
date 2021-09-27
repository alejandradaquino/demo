package com.quiz.facade.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(
    PropertyNamingStrategies.SnakeCaseStrategy::class
)
class SwapiStarship {
    lateinit var name: String
    lateinit var model: String
    lateinit var manufacturer: String
    lateinit var costInCredits: String
    lateinit var length: String
    lateinit var maxAtmospheringSpeed: String
    lateinit var crew: String
    lateinit var passengers: String
    lateinit var cargoCapacity: String
    lateinit var consumables: String
    lateinit var hyperdriveRating: String

    @JsonProperty("MGLT")
    lateinit var mglt: String
    lateinit var starshipClass: String
    lateinit var pilots: List<String>
    lateinit var films: List<String>
}
