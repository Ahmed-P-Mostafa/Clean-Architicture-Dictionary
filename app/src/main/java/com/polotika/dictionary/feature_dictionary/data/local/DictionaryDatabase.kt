package com.polotika.dictionary.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.polotika.dictionary.feature_dictionary.data.local.entity.WordInfoEntity

@Database(entities = [WordInfoEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DictionaryDatabase :RoomDatabase() {

    abstract val dao:WordInfoDao

}