package com.droidmonk.hiltdemo.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.droidmonk.hiltdemo.App
import com.droidmonk.hiltdemo.MainActivity
import com.droidmonk.hiltdemo.R
import com.droidmonk.hiltdemo.data.model.UserData

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val appContainer=(application as App).appContainer
        val loginViewModel=appContainer.loginViewModelFactory.create()

        loginViewModel.loginStatus.observe(this, Observer {
            if(it)
            startActivity(Intent(this@LoginActivity,MainActivity::class.java).apply {
                putExtra("message",loginViewModel.message)
            })
        })

        findViewById<Button>(R.id.btn_login).setOnClickListener {
            val userName=findViewById<EditText>(R.id.user_name).text.toString();
            val password=findViewById<EditText>(R.id.password).text.toString();
            loginViewModel.attemptLogin(UserData(userName,password))
        }

    }
}