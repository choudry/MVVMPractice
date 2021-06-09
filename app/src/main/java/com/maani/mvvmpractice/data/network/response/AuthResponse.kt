package com.maani.mvvmpractice.data.network.response

import com.maani.mvvmpractice.data.localdb.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User

)