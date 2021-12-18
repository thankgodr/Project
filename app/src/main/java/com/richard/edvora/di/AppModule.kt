package com.richard.edvora.di

import com.richard.edvora.Constants
import com.richard.edvora.feature_homepage.data.remote.EdvoraApi
import com.richard.edvora.feature_homepage.data.repository.ProductRepositoryImpl
import com.richard.edvora.feature_homepage.domain.repisitory.ProductRepisotory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEdvoraApi() : EdvoraApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EdvoraApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(api : EdvoraApi) : ProductRepisotory{
        return ProductRepositoryImpl(api)
    }
}