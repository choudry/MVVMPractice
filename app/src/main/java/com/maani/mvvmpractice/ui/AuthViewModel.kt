package com.maani.mvvmpractice.ui

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.maani.mvvmpractice.data.reposiotries.UserRepository
import com.maani.mvvmpractice.ui.auth.AuthListener
import com.maani.mvvmpractice.utill.Coroutines

class AuthViewModel : ViewModel() {

    var semail: String? = null
    var spassword: String? = null
    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {

        authListener?.onStarted()

        if (semail.isNullOrEmpty() || spassword.isNullOrEmpty()) {

            authListener?.onFailiure("Required field missing..!")

        } else {
            Coroutines.main {
                val response =    UserRepository().userLogin(semail!!, spassword!!)
                Log.i("Log","$response")
                if (response.isSuccessful){
                    authListener?.onSuccess(response.body()?.user)
                }else{
                    authListener?.onFailiure("Error Code: ${response.code()}")
                }
            }

        }
    }
}