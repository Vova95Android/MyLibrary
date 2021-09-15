package com.example.mylibrary.ui.start.reducer

import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorResult
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorState
import com.example.mylibrary.ui.start.StartResult
import com.example.mylibrary.ui.start.StartState

class StartResultReducer : Reducer<StartResult, StartState> {
    override fun invoke(result: StartResult, state: StartState): StartState {
        return state
    }
}
