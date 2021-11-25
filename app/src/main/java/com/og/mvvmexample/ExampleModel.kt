package com.og.mvvmexample

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ExampleModel {

    val stringsLiveData: MutableLiveData<List<String>> = MutableLiveData<List<String>>()

    //here we can get data from room or retrofit or ...
    fun getStrings() {
        stringsLiveData.value = listOf("String", "More string")
        CoroutineScope(Job() + Dispatchers.Main).launch {
            delay(3000)
            stringsLiveData.postValue(listOf("String", "More string", "Abc"))
        }
    }

}