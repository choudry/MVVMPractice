package com.maani.mvvmpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.maani.mvvmpractice.R
import com.maani.mvvmpractice.data.localdb.entities.User
import com.maani.mvvmpractice.databinding.ActivityLoginBinding
import com.maani.mvvmpractice.ui.auth.AuthListener
import com.maani.mvvmpractice.utill.hide
import com.maani.mvvmpractice.utill.show
import com.maani.mvvmpractice.utill.toast

class LoginActivity : AppCompatActivity(), AuthListener {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
        this.title = "Login Activity"


    }

    //Overriding methods of AuthListener Interface...
    override fun onStarted() {
        binding.progressBar.show()
        toast("Call started..")

    }

    override fun onSuccess(user: User?) {
        binding.progressBar.hide()
        toast("${user?.name} is logged in..")
    }

    override fun onFailiure(message: String) {
        binding.progressBar.hide()
        toast(message)
    }
}