package com.polotika.dictionary.feature_dictionary.data.util

import java.lang.reflect.Type
import java.time.temporal.Temporal

interface JsonParser {

    fun <T> fromJson(json:String,type:Type):T?

    fun <T> toJson(obj:T,type:Type):String
}