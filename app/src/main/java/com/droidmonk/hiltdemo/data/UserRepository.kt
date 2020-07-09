package com.droidmonk.hiltdemo.data

class UserRepository(val localDataSource: LocalDataSource,val remoteDateSource: RemoteDateSource): DataSource {
    override fun authenticate(
        userName: String,
        password: String,
        callback: DataSource.Callback
    ) {
        remoteDateSource.authenticate(userName,password,object : DataSource.Callback{
            override fun response(status: Boolean) {
                callback.response(status)
            }
        })
    }
}