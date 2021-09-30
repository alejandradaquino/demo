package com.quiz.model

data class Character(var id: Long, var name: String, var planetId: Long, var starshipId: List<Long>)