package com.droidmonk.hiltdemo.ui.login

import androidx.lifecycle.MutableLiveData
import com.droidmonk.hiltdemo.data.DataSource
import com.droidmonk.hiltdemo.data.UserRepository
import com.droidmonk.hiltdemo.data.model.UserData

class LoginViewModel(private val userRepository: UserRepository) {

    var loginStatus=MutableLiveData<Boolean>().apply{
        value=false
    }

    var message=""

    fun attemptLogin(userData: UserData)
    {
        userRepository.authenticate(userData.username,userData.username,object : DataSource.Callback{
            override fun response(status: Boolean) {
                loginStatus.value=status

                if(status)
                    message="Welcome ${userData.username} , you have successfully logged in"
                else
                    message="Hey ${userData.username}, some error occurred while login you in"
            }
        })
    }
}