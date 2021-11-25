package com.og.mvvmexample

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

//know about model
class ExampleRepository @Inject constructor(private val exampleModel: ExampleModel) {

    var stringsLiveData: MutableLiveData<List<String>> = exampleModel.stringsLiveData

    //ask model to fetch data
    fun fetchData() {
        exampleModel.getStrings()
    }


}