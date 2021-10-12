package com.krujz.infrastructure.ondevicedb

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Insert
import com.krujz.domain.models.MovieModel

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addNewMovie(movie: MovieModel)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addCollectionOfNewMovies(movie: Collection<MovieModel>)

    @Query("SELECT * FROM movie_db")
    fun getAllMovies() : LiveData<List<MovieModel>>

    @Delete
    suspend fun deleteMovie(movie: MovieModel)

    @Update(entity = MovieModel::class)
    suspend fun updateMovie(movie: MovieModel)
}