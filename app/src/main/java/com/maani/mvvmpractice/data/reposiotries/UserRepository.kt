package com.maani.mvvmpractice.data.reposiotries

import com.maani.mvvmpractice.data.network.AuthAPI
import com.maani.mvvmpractice.data.network.SafeApiRequest
import com.maani.mvvmpractice.data.network.response.AuthResponse
import retrofit2.Response

class UserRepository : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {

        return AuthAPI().userLogin(email, password)
    }
}