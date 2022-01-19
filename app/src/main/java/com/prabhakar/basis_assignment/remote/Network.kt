package com.prabhakar.basis_assignment.remote

import com.prabhakar.basis_assignment.Constraints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)


//Making Network call

object Network {
    val httpLoggingInterceptor = HttpLoggingInterceptor.Level.BODY
    private fun retrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Constraints.BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    //    Calling APIService and after create Provide it's to use anywhere
    @Provides
    fun provideAPIService(): APIService {
        return retrofitInstance().create(APIService::class.java)
    }
}