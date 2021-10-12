package com.krujz.infrastructure.usecases

import com.krujz.application.MovieApi
import com.krujz.application.MovieDetailsResult.*
import com.krujz.application.Result
import com.krujz.application.entities.MovieEntity
import com.krujz.application.usecase_interfaces.IFetchMovieUseCase
import com.krujz.application.entities.responseschemas.MovieCollectionResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.awaitResponse

class FetchMovieUseCase(private val movieApi: MovieApi) : BaseFetchUseCase(), IFetchMovieUseCase {

    override suspend fun fetchCollectionOfPopularMovies(apiKey: String, page: Int): Result {
        return withContext(Dispatchers.IO) {

            var result : Result
            try {
                val response = movieApi.getPopularMovies(apiKey, page).awaitResponse()
                result = getCollectionResultOnResponse(response)
                return@withContext result
            }
            catch (t: Throwable){
                result = catchError(t)
                return@withContext result
            }
        }
    }

    override suspend fun fetchCollectionOfTopRatedMovies(apiKey: String, page: Int): Result {
        return withContext(Dispatchers.IO) {
            var result: Result
            try {
                val response = movieApi.getTopRatedMovies(apiKey, page).awaitResponse()
                result = getCollectionResultOnResponse(response)
                return@withContext result
            } catch (t: Throwable) {
                result = catchError(t)
                return@withContext result
            }
        }
    }

    override suspend fun fetchSelectedMovieById(apiKey: String, movieId: Int): Result {
        return withContext(Dispatchers.IO) {
            var result: Result
            try {
                val response = movieApi.getSelectedMovieById(apiKey, movieId = movieId).awaitResponse()
                result = getSingleResultOnResponse(response)
                return@withContext result
            } catch (t: Throwable) {
                result = catchError(t)
                return@withContext result
            }
        }
    }

    private fun getCollectionResultOnResponse(response: Response<MovieCollectionResponse>) : Result {
        return when(response.isSuccessful && response.body() != null ) {
            true  -> {
                val collectionOfMovies = response.body()!!.results
                CollectionSuccess(collectionOfMovies)
            }
            false -> {
                val errorBody = getConvertedErrorBody(response.errorBody())
                whenErrorOccursSetTheErrorMessage(errorBody)
            }
        }
    }

    private fun getSingleResultOnResponse(response: Response<MovieEntity>) : Result {
        return when(response.isSuccessful && response.body() != null ) {
            true -> {
                val movie = response.body()!!
                SingleItemSuccess(movie)
            }
            false -> {
                val errorBody = getConvertedErrorBody(response.errorBody())
                whenErrorOccursSetTheErrorMessage(errorBody)
            }
        }
    }
}