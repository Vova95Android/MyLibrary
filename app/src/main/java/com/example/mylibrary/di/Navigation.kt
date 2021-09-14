package com.example.mylibrary.di

import com.example.mylibrary.navigation.Router
import com.example.mylibrary.navigation.RouterImpl
import org.koin.dsl.module

val navigationModule = module {
    single<Router> { RouterImpl() }
}
