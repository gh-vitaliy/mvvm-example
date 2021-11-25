package com.og.mvvmexample

import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    //or create inject fun with application class parameter and use it everywhere
}