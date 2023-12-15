package com.example.kerjaparaktik

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("register.php")
    fun performUserSignIn(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("email") email: String
    ): Call<ApiResponse>


    @FormUrlEncoded
    @POST("login.php")
    fun performUserLogin(@Field("name") name: String, @Field("password") password: String): Call<ApiResponse>
}
