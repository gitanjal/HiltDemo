package com.droidmonk.hiltdemo

import com.droidmonk.hiltdemo.ui.login.LoginViewModel

interface Factory {
    fun create():LoginViewModel
}