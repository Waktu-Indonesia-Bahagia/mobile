package com.example.kerjaparaktik

import com.google.gson.annotations.SerializedName

class ApiResponse(
    @SerializedName("status")
    private val status: String,

    @SerializedName("result_code")
    private val resultCode: Int,

    @SerializedName("name")
    private val name: String,

    @SerializedName("nama")
    private val nama: String,

    @SerializedName("email")
    private val email: String,

    @SerializedName("no_telepon")
    private val no_telepon: String,

    @SerializedName("asal_kampus")
    private val asal_kampus: String,

    @SerializedName("alamat")
    private val alamat: String

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
    fun getnama(): String {
        return nama
    }
    fun getemail(): String{
        return email
    }
    fun getno_telepon(): String{
        return no_telepon
    }
    fun getasal_kampus():String{
        return asal_kampus
    }
    fun getalamat():String{
        return alamat
    }
}
