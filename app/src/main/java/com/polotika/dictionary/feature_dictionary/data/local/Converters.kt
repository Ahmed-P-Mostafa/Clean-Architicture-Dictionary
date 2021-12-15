package com.polotika.dictionary.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.polotika.dictionary.feature_dictionary.data.remote.dto.MeaningDto
import com.polotika.dictionary.feature_dictionary.data.util.JsonParser
import com.polotika.dictionary.feature_dictionary.domain.model.Meaning

@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {

    @TypeConverter
    fun fromMeaningsJson(json:String):List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(json,object :TypeToken<ArrayList<Meaning>>(){}.type)?: emptyList()
    }

    fun toMeaningJson(meaning:List<Meaning>):String{
        return jsonParser.toJson(meaning,object :TypeToken<ArrayList<Meaning>>(){}.type)?: "[]"
    }
}