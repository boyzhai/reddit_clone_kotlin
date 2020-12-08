package com.app.redditkotlin.Model

import com.google.gson.annotations.SerializedName

data class nationality(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String

)