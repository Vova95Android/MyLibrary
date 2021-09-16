package com.example.mylibrary.di

import com.example.mylibrary.Constants
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.navigation.RouterImpl
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

fun globalRouter() = StringQualifier(Constants.QUALIFIER_ROUTER_GLOBAL)
fun booksRouter() = StringQualifier(Constants.QUALIFIER_ROUTER_BOOKS)
fun authorsRouter() = StringQualifier(Constants.QUALIFIER_ROUTER_AUTHORS)

val navigationModule = module {
    single<Router>(globalRouter()) { RouterImpl() }
    single<Router>(booksRouter()) { RouterImpl() }
    single<Router>(authorsRouter()) { RouterImpl() }
}
