package com.droidmonk.hiltdemo

import com.droidmonk.hiltdemo.data.LocalDataSource
import com.droidmonk.hiltdemo.data.RemoteDateSource
import com.droidmonk.hiltdemo.data.UserRepository
import retrofit2.Retrofit

class AppContainer {
    private val retrofit= Retrofit.Builder().baseUrl("http://droidmonk.com").build()
    private val localDataSource= LocalDataSource()
    private val remoteDateSource= RemoteDateSource(retrofit)
    val repository= UserRepository(localDataSource,remoteDateSource)
}