package com.example.mylibrary.di

import com.example.mylibrary.ui.activity.MainViewModel
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorsViewModel
import com.example.mylibrary.ui.authors.addAuthors.usecase.SaveAuthorUseCase
import com.example.mylibrary.ui.authors.authorList.AuthorListViewModel
import com.example.mylibrary.ui.authors.authorList.usecase.LoadAuthorListUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(get())
    }
    viewModel {
        AddAuthorsViewModel(
            useCaseSet = setOf(
                get<SaveAuthorUseCase>()
            ),
            get()
        )
    }
    viewModel {
        AuthorListViewModel(
            useCaseSet = setOf(
                get<LoadAuthorListUseCase>(),
            ),
            get()
        )
    }
}
