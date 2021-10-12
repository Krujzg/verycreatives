package com.krujz.infrastructure.ondevicedb.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.krujz.domain.models.LanguageModel

class LanguageTypeConverter {

    @TypeConverter
    fun fromLanguageCollection(value: Collection<LanguageModel>): String {
        val gson = Gson()
        val type = object : TypeToken<Collection<LanguageModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toLanguageCollection(value: String): Collection<LanguageModel> {
        val gson = Gson()
        val type = object : TypeToken<Collection<LanguageModel>>() {}.type
        return gson.fromJson(value, type)
    }
}