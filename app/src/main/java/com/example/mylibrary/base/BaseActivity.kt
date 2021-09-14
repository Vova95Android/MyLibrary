package com.example.mylibrary.base

import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseActivity<VM : BaseViewModel<*, *, *>>: AppCompatActivity() {

    protected val viewModel: VM by lazy {
        getViewModel(clazz = viewModelKClass())
    }

    @Suppress("UNCHECKED_CAST")
    private fun viewModelKClass(): KClass<VM> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<VM>).kotlin
    }
}