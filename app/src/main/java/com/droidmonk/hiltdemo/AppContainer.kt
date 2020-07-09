package com.droidmonk.hiltdemo

import com.droidmonk.hiltdemo.data.LocalDataSource
import com.droidmonk.hiltdemo.data.RemoteDateSource
import com.droidmonk.hiltdemo.data.UserRepository
import com.droidmonk.hiltdemo.ui.login.LoginViewModelFactory
import retrofit2.Retrofit

class AppContainer {
    private val retrofit= Retrofit.Builder().baseUrl("http://droidmonk.com").build()
    private val localDataSource= LocalDataSource()
    private val remoteDateSource= RemoteDateSource(retrofit)
    private val repository= UserRepository(localDataSource,remoteDateSource)
    val loginViewModelFactory=LoginViewModelFactory(repository)
}