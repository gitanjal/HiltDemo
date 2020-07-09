package com.droidmonk.hiltdemo.data

interface DataSource {
    interface Callback{
        fun response(status: Boolean)
    }

    fun authenticate(userName:String,password:String,callback: Callback)
}