package com.krujz.application

import com.krujz.application.entities.MovieEntity
import com.krujz.application.entities.responseschemas.MovieCollectionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1,
    ) : Call<MovieCollectionResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1,
    ) : Call<MovieCollectionResponse>

    @GET("movie/{movie_id}")
    fun getSelectedMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
    ) : Call<MovieEntity>
}