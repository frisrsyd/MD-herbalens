package com.dicoding.md_herbalens.api

import com.dicoding.md_herbalens.model.LoginResponse
import com.dicoding.md_herbalens.model.PlantResponse
import com.dicoding.md_herbalens.model.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("plants")
    fun getAllPlants(
    ): Call<List<PlantResponse>>

    @GET("plants/{id}")
    fun getDetailPlant(
        @Path("id") id: Int
    ): Call<PlantResponse>

    @GET("plants")
    fun getPlants(
        @Query("name") name: String
    ): Call<List<PlantResponse>>

    @FormUrlEncoded
    @POST("login")
    fun doLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    fun onRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterResponse>
}