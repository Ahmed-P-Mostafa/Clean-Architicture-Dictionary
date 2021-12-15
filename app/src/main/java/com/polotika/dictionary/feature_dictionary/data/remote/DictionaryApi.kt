package com.polotika.dictionary.feature_dictionary.data.remote

import com.polotika.dictionary.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("/api/v2/entries/en/{word}")
    fun getWordInfo(@Path("word") word:String) :List<WordInfoDto>

}