package com.quiz.builders

import com.quiz.model.Character
import com.quiz.model.Starship
import com.quiz.utils.IdExtractor

class StarshipTestBuilder {

    var id: Long = 34L
    var name: String = "Death Star"
    var model: String = "DS-1 Orbital Battle Station"
    var manufacturer: String = "Imperial Department of Military Research, Sienar Fleet Systems"
    var costInCredits: String = "1000000000000"
    var length: String = "120000"
    var maxAtmospheringSpeed: String = "n/a"
    var crew: String = "342,953"
    var passengers: String = "843,342"
    var cargoCapacity: String = "1000000000000"
    var consumables: String = "3 years"
    var hyperdriveRating: String = "4.0"
    var mglt: String = "10"
    var starshipClass: String = "Deep Space Mobile Battlestation"
    var pilotsIds: List<Long> = listOf()
    var films: List<String> = listOf()

    fun build() = Starship(
        id,
        name,
        model,
        manufacturer,
        costInCredits,
        length,
        maxAtmospheringSpeed,
        crew,
        passengers,
        cargoCapacity,
        consumables,
        hyperdriveRating,
        mglt,
        starshipClass,
        pilotsIds,
        films
    )

    fun withId(id: Long): StarshipTestBuilder {
        this.id = id
        return this
    }
}