package com.krujz.infrastructure.ondevicedb

import android.content.Context
import androidx.room.*
import com.krujz.domain.models.MovieModel
import com.krujz.infrastructure.ondevicedb.typeconverters.GenreTypeConverter
import com.krujz.infrastructure.ondevicedb.typeconverters.LanguageTypeConverter

@Database(entities = [MovieModel::class], version = 1, exportSchema = false)
abstract class MovieOnDeviceDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        var INSTANCE: MovieOnDeviceDatabase? = null

        fun getDatabase(context: Context): MovieOnDeviceDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) { return tempInstance }

            synchronized(this) {
                val instance =  Room.databaseBuilder(context.applicationContext,
                    MovieOnDeviceDatabase::class.java,"movie_db")
                        .build()

                INSTANCE = instance
                return instance;
            }
        }
    }
}