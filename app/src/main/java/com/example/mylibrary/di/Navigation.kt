package com.example.mylibrary.di

import com.example.mylibrary.Constants
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.navigation.RouterImpl
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

fun globalRouter() = StringQualifier(Constants.QUALIFIER_ROUTER_GLOBAL)
fun channelsRouter() = StringQualifier(Constants.QUALIFIER_ROUTER_CHANNELS)
fun donateRouter() = StringQualifier(Constants.QUALIFIER_ROUTER_DONATE)
fun favoritesRouter() = StringQualifier(Constants.QUALIFIER_ROUTER_FAVORITES)
fun libraryRouter() = StringQualifier(Constants.QUALIFIER_ROUTER_LIBRARY)
fun profileRouter() = StringQualifier(Constants.QUALIFIER_ROUTER_PROFILE)

val navigationModule = module {
    single<Router>(globalRouter()) { RouterImpl() }
    single<Router>(channelsRouter()) { RouterImpl() }
    single<Router>(donateRouter()) { RouterImpl() }
    single<Router>(favoritesRouter()) { RouterImpl() }
    single<Router>(libraryRouter()) { RouterImpl() }
    single<Router>(profileRouter()) { RouterImpl() }
}
