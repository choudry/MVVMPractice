package com.maani.mvvmpractice.ui.auth

import com.maani.mvvmpractice.data.localdb.entities.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(loginResponse: User?)
    fun onFailiure(message:String)

}