package com.polotika.dictionary.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.polotika.dictionary.feature_dictionary.data.local.DictionaryDatabase
import com.polotika.dictionary.feature_dictionary.data.local.WordInfoDao
import com.polotika.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.polotika.dictionary.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.polotika.dictionary.feature_dictionary.data.util.GsonParser
import com.polotika.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import com.polotika.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DictionaryAppModule {

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder().baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(DictionaryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDictionaryDatabase(app: Application): DictionaryDatabase {
        return Room.databaseBuilder(app, DictionaryDatabase::class.java, "word_db")
            .addTypeConverter(GsonParser(Gson()))
            .build()
    }

    @Provides
    @Singleton
    fun provideGetWordInfo(repository: WordInfoRepository):GetWordInfo{
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(api:DictionaryApi,db: DictionaryDatabase):WordInfoRepository{
        return WordInfoRepositoryImpl(api,db.dao)
    }
}