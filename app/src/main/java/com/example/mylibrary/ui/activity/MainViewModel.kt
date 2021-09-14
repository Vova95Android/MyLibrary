package com.example.mylibrary.ui.activity

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.navigation.Router

class MainViewModel(
    router: Router
): BaseViewModel<Any, Any, Any>(
    actionReducer = MainActionReducer(),
    resultReducer = MainResultReducer(),
    useCaseSet = emptySet(),
    initialState = Any(),
    router = router
) {
}

class MainActionReducer : Reducer<Any, Any> {
    override fun invoke(action: Any, state: Any): Any {
        return state
    }
}
class MainResultReducer : Reducer<Any, Any> {
    override fun invoke(result: Any, state: Any): Any {
        return state
    }
}