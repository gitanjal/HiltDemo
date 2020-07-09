package com.droidmonk.hiltdemo.data

import retrofit2.Retrofit

class RemoteDateSource (retrofit: Retrofit):DataSource{
    override fun authenticate(
        userName: String,
        password: String,
        callback: DataSource.Callback
    ) {
        callback.response(true)
    }
}