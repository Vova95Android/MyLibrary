package com.example.mylibrary.base.mvi

abstract class UseCase<Action, State, Result> {

    var error: String? = null

    abstract fun map(action: Action, state: State): Result

    abstract fun canHandle(action: Action): Boolean

}
