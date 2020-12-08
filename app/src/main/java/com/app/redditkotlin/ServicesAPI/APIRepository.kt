package com.app.redditkotlin.ServicesAPI

import android.app.Activity
import com.app.redditkotlin.Application.BaseApplication
import com.app.redditkotlin.Model.nationality
import com.app.redditkotlin.ui.main.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


class APIRepository {
        companion object {
        fun getCountryList(activity: MainViewModel, getCountryList:APICallBack.LoadNationality) {
            val call: Call<List<nationality>> = BaseApplication.apiServices.getNationality()
            call.enqueue(object : Callback<List<nationality>> {
                override fun onFailure(call: Call<List<nationality>>, t: Throwable) {
                    Timber.d(t.message)
                }

                override fun onResponse(
                    call: Call<List<nationality>>,
                    response: Response<List<nationality>>
                ) {
                    Timber.d(response.body().toString())
                }
            })
        }
    }

}