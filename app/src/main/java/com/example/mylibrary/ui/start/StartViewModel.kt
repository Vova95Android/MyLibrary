package com.example.mylibrary.ui.start

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.start.reducer.StartActionReducer
import com.example.mylibrary.ui.start.reducer.StartResultReducer

class StartViewModel(
    useCaseSet: Set<UseCase<StartAction, StartState, StartResult>>,
    router: Router
): BaseViewModel<StartAction, StartState, StartResult>(
    actionReducer = StartActionReducer(),
    resultReducer = StartResultReducer(),
    useCaseSet = useCaseSet,
    initialState = StartState(),
    router = router
) {
}