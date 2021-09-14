package com.example.mylibrary.di

import com.example.mylibrary.ui.activity.MainViewModel
import com.example.mylibrary.ui.addAuthors.AddAuthorsViewModel
import com.example.mylibrary.ui.addAuthors.usecase.SaveAuthorUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel()
    }
    viewModel {
        AddAuthorsViewModel(
            useCaseSet = setOf(
                get<SaveAuthorUseCase>()
            )
        )
    }
}
