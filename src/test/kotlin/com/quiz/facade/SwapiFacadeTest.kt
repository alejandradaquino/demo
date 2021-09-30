package com.quiz.facade

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.quiz.facade.model.SwapiCharacter
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import jakarta.inject.Inject
import org.assertj.core.api.Assert
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.reactivestreams.Publisher
import java.io.File
import java.io.FileReader

@ExtendWith(MockitoExtension::class)
class SwapiFacadeTest() {
    @Mock
    private lateinit var blocking: BlockingHttpClient

    @Mock
    lateinit var httpClient: HttpClient

    private val mapper = ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    @BeforeEach
    fun setUp() {
        Mockito.doReturn(blocking).`when`(httpClient).toBlocking();
        val luke = mapper.readValue(File("src/test/resources/Luke.json"), SwapiCharacter::class.java)
        Mockito.`when`(blocking.retrieve(Mockito.startsWith("/people/"), Mockito.any(Class::class.java)))
            .thenReturn(luke)
    }

    @Test
    fun test() {

        Assertions.assertThat(httpClient).isNotNull

        val characters = SwapiFacade(httpClient, mapper).getAllCharacters()

        Assertions.assertThat(characters).isNotNull
    }
}