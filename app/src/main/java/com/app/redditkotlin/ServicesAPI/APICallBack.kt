package com.app.redditkotlin.ServicesAPI

import com.app.redditkotlin.Model.nationality

class APICallBack {
    interface LoadNationality{
        fun onSuccess(nationality: List<nationality>?)
        fun onError(error: String)
        fun onException(error: Throwable)
    }
}