package com.og.mvvmexample

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData

class ExampleViewModel()
    : BaseObservable() { //add observable for dataBinding
    private val exampleRepository= ExampleRepository()
    //know about repo
    var stringsLiveData: MutableLiveData<List<String>> = exampleRepository.stringsLiveData

    init {
        //ask repository to ask model to fetch data
        exampleRepository.fetchData()
    }


    @get:Bindable //observe changes in this variable
    var stringsText: String? = null
        get() {
            notifyChange() //notify dataBinding about changes
            return stringsLiveData.value.toString()
        }
        set(value) {
            notifyChange() //notify dataBinding about changes
            field = value
        }


}