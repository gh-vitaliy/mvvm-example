package com.og.mvvmexample

import androidx.lifecycle.MutableLiveData

class ExampleRepository {
    private val exampleModel = ExampleModel()//know about model
    var stringsLiveData: MutableLiveData<List<String>> = exampleModel.stringsLiveData

    //ask model to fetch data
    fun fetchData() {
        exampleModel.getStrings()
    }


}