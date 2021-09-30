package com.quiz.utils

object IdExtractor {
    fun extract(value: String): Long {
        return value.split("/").filterNot { it == "" }.last().toLong()
    }
}