package com.example.mylibrary.ui.start.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorAction
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorState
import com.example.mylibrary.ui.start.StartAction
import com.example.mylibrary.ui.start.StartState

class StartActionReducer : Reducer<StartAction, StartState> {
    override fun invoke(action: StartAction, state: StartState): StartState {
        return state
    }
}
