package com.polotika.dictionary.feature_dictionary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polotika.dictionary.feature_dictionary.data.local.entity.WordInfoEntity

@Dao
interface WordInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfo(infos:List<WordInfoEntity>)

    @Query("DELETE FROM WORDINFOENTITY WHERE word IN (:words)")
    suspend fun deleteWordInfo(words:List<String>)

    @Query("SELECT * FROM WORDINFOENTITY WHERE WORD LIKE '%' || :word || '%' ")
    suspend fun getWordInfo(word:String):List<WordInfoEntity>
}