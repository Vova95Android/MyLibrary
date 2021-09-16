package com.example.mylibrary.di

import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.data.repository.AuthorRepositoryImpl
import com.example.mylibrary.data.repository.BookRepository
import com.example.mylibrary.data.repository.BookRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<AuthorRepository> { AuthorRepositoryImpl(get()) }
    factory<BookRepository> { BookRepositoryImpl(get()) }
}
