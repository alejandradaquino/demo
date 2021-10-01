package com.quiz.repositories

import com.quiz.model.Starship

interface StarshipRepository {
    fun findById(it: Long): Starship

}
