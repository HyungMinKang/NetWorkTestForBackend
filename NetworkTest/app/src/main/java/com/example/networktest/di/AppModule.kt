package com.example.networktest.di

import com.example.networktest.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel{ TestViewModel(get())}
}