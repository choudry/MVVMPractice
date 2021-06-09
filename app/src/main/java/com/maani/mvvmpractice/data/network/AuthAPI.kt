package com.maani.mvvmpractice.data.network

import com.maani.mvvmpractice.data.network.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthAPI {
    @FormUrlEncoded
    @POST("login")
    //suspended functions are the center of coroutines. Suspended functions can be paused and resumed at later time.
    // So these functions can execute long running operation and wait for it without blocking.
    suspend fun userLogin(
        @Field ("email")email:String,
        @Field("password")password:String
    ) : Response<AuthResponse>

    companion object{
    operator fun invoke() : AuthAPI {
        return Retrofit.Builder().baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthAPI::class.java)
    }

    }
}
