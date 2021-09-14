package com.example.mylibrary.di

import com.example.mylibrary.ui.activity.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel {
        MainViewModel()
    }
}

