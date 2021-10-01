package com.quiz.repositories

import com.quiz.model.Planet

interface PlanetRepository {
    fun findByName(name: String): Planet
    fun save(it: Planet)
}
