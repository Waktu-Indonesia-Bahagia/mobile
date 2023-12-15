package com.example.kerjaparaktik

import com.google.gson.annotations.SerializedName

class ApiResponse(
    @SerializedName("status")
    private val status: String,

    @SerializedName("result_code")
    private val resultCode: Int,

    @SerializedName("name")
    private val name: String
) {
    fun getStatus(): String {
        return status
    }

    fun getResultCode(): Int {
        return resultCode
    }

    fun getName(): String {
        return name
    }
}
