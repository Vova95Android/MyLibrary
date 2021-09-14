package com.example.mylibrary.di

import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.data.repository.AuthorRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<AuthorRepository> { AuthorRepositoryImpl(get()) }
}
