package com.polotika.dictionary.feature_dictionary.domain.use_case

import com.polotika.dictionary.core.util.Resource
import com.polotika.dictionary.feature_dictionary.domain.model.WordInfo
import com.polotika.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(private val repository: WordInfoRepository) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        return if (word.isBlank()) {
            flow { }
        } else {
            repository.getWordInfo(word = word)
        }

    }
}