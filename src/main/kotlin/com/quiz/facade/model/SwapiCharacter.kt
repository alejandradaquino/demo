package com.quiz.facade.model

class SwapiCharacter {
    fun parsePlanetId(): Long {
        return 1
    }

    fun parseStarshipId(): List<Long> {
        return listOf(2)
    }

    lateinit var name: String
    lateinit var homeworld: String
    lateinit var starships: List<String>
}