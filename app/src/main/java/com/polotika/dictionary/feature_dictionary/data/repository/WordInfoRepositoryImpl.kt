package com.polotika.dictionary.feature_dictionary.data.repository

import com.polotika.dictionary.core.util.Resource
import com.polotika.dictionary.feature_dictionary.data.local.WordInfoDao
import com.polotika.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.polotika.dictionary.feature_dictionary.domain.model.WordInfo
import com.polotika.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {

    override fun getWordInfo(word: String) : Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfo = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfo))

        try {

        }catch (e:IOException){

        }catch (e:HttpException){

        }

        val newWordInfo = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))
    }
}