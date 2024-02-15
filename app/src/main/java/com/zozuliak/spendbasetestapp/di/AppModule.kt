package com.zozuliak.spendbasetestapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.zozuliak.spendbasetestapp.data.CardRepositoryImpl
import com.zozuliak.spendbasetestapp.data.ServerApi
import com.zozuliak.spendbasetestapp.model.CardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    const val BASE_URL = "https://dev.spendbase.co"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideServerApi(okHttpClient: OkHttpClient): ServerApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .client(okHttpClient)
        .build()
        .create(ServerApi::class.java)

    @Singleton
    @Provides
    fun provideCardRepository(api: ServerApi): CardRepository =
        CardRepositoryImpl(api)
}
