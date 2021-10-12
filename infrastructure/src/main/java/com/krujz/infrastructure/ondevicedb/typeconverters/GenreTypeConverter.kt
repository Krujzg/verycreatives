package com.krujz.infrastructure.ondevicedb.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.krujz.domain.models.GenreModel

class GenreTypeConverter {
    @TypeConverter
    fun fromGenreCollection(value: Collection<GenreModel>): String {
        val gson = Gson()
        val type = object : TypeToken<Collection<GenreModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGenreCollection(value: String): Collection<GenreModel> {
        val gson = Gson()
        val type = object : TypeToken<Collection<GenreModel>>() {}.type
        return gson.fromJson(value, type)
    }
}