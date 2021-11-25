package com.og.mvvmexample

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

//u can simply inject something in constructor
//but if u want to inject something outside constructor u must call inject fun from component
class ExampleViewModel @Inject constructor(private val exampleRepository: ExampleRepository) :
    BaseObservable() { //add observable for dataBinding


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