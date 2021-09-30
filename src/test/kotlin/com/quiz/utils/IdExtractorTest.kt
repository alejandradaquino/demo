package com.quiz.utils

import com.quiz.utils.IdExtractor.extract
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IdExtractorTest{
     @Test
     fun `when extracts id from urls it will return the right number`(){
         assertThat( extract( "https://swapi.dev/api/people/13/")).isEqualTo(13L)
         assertThat( extract( "https://swapi.dev/api/planets/14/")).isEqualTo(14L)
         assertThat( extract( "https://swapi.dev/api/starships/22/")).isEqualTo(22L)
     }
 }