package com.messieyawo.mymoviepaginationexample.di

import android.content.Context
import androidx.room.Room

import com.messieyawo.mymoviepaginationexample.api.MovieApi
import com.messieyawo.mymoviepaginationexample.data.local.FavoriteMovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFavMovieDatabase(@ApplicationContext app:Context) = Room.databaseBuilder(
        app,
        FavoriteMovieDatabase::class.java,
        "movie_db"
    ).build()

    @Singleton
    @Provides
    fun provideFavMovieDao(db: FavoriteMovieDatabase) = db.getFavoriteMovieDao()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}