package com.quiz.facade.model

import com.quiz.model.Character
import com.quiz.utils.IdExtractor.extract

class SwapiCharacter {
    fun parsePlanetId() = extract(homeworld)

    fun parseStarshipId() = starships.map { extract(it) }

    fun toModel(id: Long) = Character(id, name, parsePlanetId(), parseStarshipId())

    lateinit var name: String
    lateinit var homeworld: String
    lateinit var starships: List<String>
}