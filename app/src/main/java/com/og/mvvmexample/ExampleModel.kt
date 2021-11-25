package com.og.mvvmexample

import androidx.lifecycle.MutableLiveData

class ExampleModel {

    val stringsLiveData :MutableLiveData<List<String>> = MutableLiveData<List<String>>()

    //here we can get data from room or retrofit or ...
    fun getStrings(){
        stringsLiveData.value= listOf("String","More string")
    }

}