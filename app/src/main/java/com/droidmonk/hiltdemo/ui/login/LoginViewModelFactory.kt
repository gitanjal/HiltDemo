package com.droidmonk.hiltdemo.ui.login

import com.droidmonk.hiltdemo.Factory
import com.droidmonk.hiltdemo.data.UserRepository

class LoginViewModelFactory(val repository: UserRepository):Factory {
    override fun create(): LoginViewModel {
        return LoginViewModel(repository)
    }
}