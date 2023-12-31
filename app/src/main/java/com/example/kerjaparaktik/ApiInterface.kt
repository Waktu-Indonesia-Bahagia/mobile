package com.example.kerjaparaktik

import com.example.kerjaparaktik.notification.NotificationData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

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

    @FormUrlEncoded
    @POST("reset-password.php")
    fun performResetPassword(
        @Field("old_password") old_password: String,
        @Field("new_password") new_password: String,
        @Field("conform_password") conform_password: String
    ): Call<ApiResponse>

    @FormUrlEncoded
    @POST("notifikasi.php")
    fun notification(
        @Field("title") title: String,
        @Field("message") message: String
    ): Call<Void>

    @GET("get-notifications.php")
    fun getNotifications(): Call<List<NotificationData>>




    @FormUrlEncoded
    @POST("edit.php")
    fun PerfomEdit(
        @Field("nama") nama: String,
        @Field("no_telepon") no_telepon: String,
        @Field("asal_kampus") asal_kampus: String,
        @Field("alamat") alamat: String
    ): Call<ApiResponse>


    @GET("mahasiswa")
    fun data(
        @Field("nama") nama: String,
        @Field("email") email: String
    ): Call<ApiResponse>

    @FormUrlEncoded
    @POST("pendaftaran.php")
    fun performPendaftaran(
        @Field("nama") nama: String,
        @Field("asal_kampus") asal_kampus: String,
        @Field("no_telp") no_telp: String,
        @Field("email") email: String,
        @Field("magang") magang: String,
        @Field("posisi") posisi: String,
        @Field("ktp") ktp: String,
        @Field("ktm") ktm: String,
        @Field("surat_permohonan") surat_permohonan: String
    ): Call<ApiResponse>

}
