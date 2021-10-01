package com.quiz

import com.quiz.services.RepositoriesInitializerService
import com.quiz.services.StarshipsService
import io.micronaut.runtime.Micronaut.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun main(args: Array<String>) {
	val logger = LoggerFactory.getLogger(StarshipsService::class.java)
	val applicationContext = build()
		.args(*args)
		.packages("com.quiz")
		.start()

	val initializerService = applicationContext.getBean(RepositoriesInitializerService::class.java)
	initializerService.initialize()
	logger.info("Service running initialized")
}

