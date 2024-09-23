package com.example.myapplication.di

import com.example.myapplication.api_services.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class APIModule {

    @Provides
    @Singleton
    fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://data.cityofnewyork.us/resource/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ApiServices{

        return  retrofit.create(ApiServices::class.java)

    }
}