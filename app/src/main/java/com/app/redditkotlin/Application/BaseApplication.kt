package com.app.redditkotlin.Application

import android.app.Application
import android.content.res.Resources
import com.app.redditkotlin.Module.RetrofitNetworkModule
import com.app.redditkotlin.ServicesAPI.APIServices
import retrofit2.Retrofit

import timber.log.Timber

class BaseApplication : Application() {
    companion object {
        lateinit var instance: Application
        lateinit var resourses: Resources
        lateinit var apiServices: APIServices
        var initializer_message ="Timber Initializer is initialized"
       }

    override fun onCreate() {
        super.onCreate()
        instance = this
        resourses = resources
        loggingSetup()
        apiServices =  RetrofitNetworkModule.getAPI().create(APIServices::class.java)
    }

    private fun loggingSetup(){
        Timber.plant(Timber.DebugTree())
        Timber.d(initializer_message)
    }



}