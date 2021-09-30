package com.quiz.facade.model

import com.quiz.utils.IdExtractor
import com.quiz.utils.IdExtractor.extract

class SwapiCharacter {
    fun parsePlanetId() = extract(homeworld)

    fun parseStarshipId() = starships.map { extract(it) }

    lateinit var name: String
    lateinit var homeworld: String
    lateinit var starships: List<String>
}