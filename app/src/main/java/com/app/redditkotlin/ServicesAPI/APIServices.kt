package com.app.redditkotlin.ServicesAPI



import com.app.redditkotlin.Model.nationality
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.POST

interface APIServices{
    @POST("mpay/api/account/nationality")
    fun getNationality() : Call<List<nationality>>
}