package com.og.mvvmexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.og.mvvmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var exampleViewModel: ExampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //set binding
        setContentView(binding.root)

        exampleViewModel = ExampleViewModel()
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