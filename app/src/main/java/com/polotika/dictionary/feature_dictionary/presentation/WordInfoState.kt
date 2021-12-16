package com.polotika.dictionary.feature_dictionary.presentation

import com.polotika.dictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoState(val data :List<WordInfo> = emptyList(),val isLoading :Boolean = false)
