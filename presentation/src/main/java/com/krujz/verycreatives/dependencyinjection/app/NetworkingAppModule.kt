package com.krujz.verycreatives.dependencyinjection.app

import android.app.Application
import com.krujz.application.MovieApi
import com.krujz.verycreatives.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkingAppModule(private val application: Application) {

    @Provides
    fun application() = application

    @Provides
    @AppScope
    fun retrofit(okHttpClient: OkHttpClient) : Retrofit
            = Retrofit.Builder()
        .baseUrl(BuildConfig.base_url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @AppScope
    fun movieApi(retrofit: Retrofit) : MovieApi = retrofit.create(MovieApi::class.java)

    @Provides
    @AppScope
    fun logger() : HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @AppScope
    fun headerInterceptor() : Interceptor
            = Interceptor { chain ->
        var request = chain.request()
        request = request.newBuilder()
            .build()

        val response = chain.proceed(request)
        response
    }

    @Provides
    @AppScope
    fun okHttp(headerInterceptor: Interceptor, logger: HttpLoggingInterceptor) : OkHttpClient
            = OkHttpClient.Builder()
        .callTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)
        .build()
}