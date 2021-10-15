package com.krujz.infrastructure.ondevicedb

import androidx.room.*
import androidx.room.Insert
import com.krujz.domain.models.MovieModel

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addNewMovie(movie: MovieModel)

    @Query("SELECT * FROM movie_db")
    fun getAllMovies() : Array<MovieModel>

    @Query("SELECT * FROM movie_db WHERE id = :movieId")
    fun getSelectedMovieFavoriteStatus(movieId: Int) : MovieModel?

    @Delete
    suspend fun deleteMovie(movie: MovieModel)

    @Update(entity = MovieModel::class)
    suspend fun updateMovie(movie: MovieModel)
}