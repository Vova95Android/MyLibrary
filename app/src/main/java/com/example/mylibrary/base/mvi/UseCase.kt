package com.example.mylibrary.base.mvi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


abstract class UseCase<Action, State, Result> {

    var error: String? = null

    protected val sideEffectMutableLiveData = MutableLiveData<Result>()
    val sideEffectLiveData: LiveData<Result>
        get() = sideEffectMutableLiveData

    abstract fun map(action: Action, state: State): Result

    abstract fun canHandle(action: Action): Boolean

}