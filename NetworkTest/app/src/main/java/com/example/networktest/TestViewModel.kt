package com.example.networktest

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networktest.domain.Repository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class TestViewModel(private val repository: Repository) :ViewModel()
{
    private val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            Log.e("Error", ": ${throwable.message}")
        }

    fun apiTest(){
        viewModelScope.launch(coroutineExceptionHandler){
            val res = repository.apiTest1()
            println(res.user_id)
            println(res.user_name)
        }
    }
}