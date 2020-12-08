package com.app.redditkotlin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.redditkotlin.Model.nationality
import com.app.redditkotlin.ServicesAPI.APICallBack
import com.app.redditkotlin.ServicesAPI.APIRepository

class MainViewModel(private val countryList : List<nationality>) : ViewModel() {
    // TODO: Implement the ViewModel
    fun getList() {
        APIRepository.getCountryList(this , object  : APICallBack.LoadNationality{
            override fun onError(error: String) {
                TODO("Not yet implemented")
            }

            override fun onException(error: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onSuccess(nationality: List<nationality>?) {

            }
        })
    }



}

