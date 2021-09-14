package com.example.mylibrary.di

import com.example.mylibrary.ui.authors.addAuthors.usecase.SaveAuthorUseCase
import com.example.mylibrary.ui.authors.authorList.usecase.LoadAuthorListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SaveAuthorUseCase(get()) }
    factory { LoadAuthorListUseCase(get()) }
}
