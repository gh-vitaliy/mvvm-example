package com.og.mvvmexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.og.mvvmexample.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject //only on non private variables
    lateinit var exampleViewModel: ExampleViewModel //injected from module

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.create().inject(this) // u can create this component in application class and use it everywhere without constant recreation
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //set binding
        setContentView(binding.root)

        binding.viewModel = exampleViewModel //set viewModel to binding

        setObservers()
    }

    //observe list changes
    private fun setObservers() {
        exampleViewModel.stringsLiveData.observe(this) { strings ->
            strings?.let {
                Toast.makeText(this, strings.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}