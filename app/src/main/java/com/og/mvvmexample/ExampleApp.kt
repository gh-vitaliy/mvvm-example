package com.og.mvvmexample

import android.app.Application
import android.content.Context

class ExampleApp : Application() {
    init {
        INSTANCE = this
    }

    companion object {
        var INSTANCE: ExampleApp? = null
        fun getContext(): Context = INSTANCE!!.applicationContext
    }
}