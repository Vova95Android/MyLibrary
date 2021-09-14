package com.example.mylibrary.di

import com.example.mylibrary.ui.addAuthors.usecase.SaveAuthorUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SaveAuthorUseCase(get()) }
}
