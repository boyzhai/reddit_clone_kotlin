package com.app.redditkotlin.Module

import com.app.redditkotlin.Application.BaseApplication
import com.app.redditkotlin.R
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

class RetrofitNetworkModule() {

    //global initialize object
    companion object {
        var baseURL = BaseApplication.resourses.getString(R.string.api_domain)
        var timeout_second = 120;

        private val interceptor = run {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

        fun getAPI() : Retrofit {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpRequestInterceptor())
            .addNetworkInterceptor(interceptor)
            .connectTimeout(timeout_second.toLong(), TimeUnit.SECONDS)
            .writeTimeout(timeout_second.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeout_second.toLong(), TimeUnit.SECONDS)
            .build()
    }



    class HttpRequestInterceptor : Interceptor {

        /**
         * Interceptor class for setting of the headers for every request
         */
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request = request?.newBuilder()
//                    ?.addHeader("Content-Type", "application/json")
//                    ?.addHeader("Accept", "application/json")
                ?.build()
            Timber.d(request.toString())
            return chain.proceed(request)
        }
    }


}
