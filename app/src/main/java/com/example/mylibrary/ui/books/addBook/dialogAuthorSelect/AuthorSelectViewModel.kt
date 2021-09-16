package com.example.mylibrary.ui.books.addBook.dialogAuthorSelect

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.reducer.AuthorSelectActionReducer
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.reducer.AuthorSelectResultReducer
import com.example.mylibrary.ui.model.AuthorUI

class AuthorSelectViewModel(
    useCaseSet: Set<UseCase<AuthorSelectAction, AuthorSelectState, AuthorSelectResult>>,
    router: Router
) : BaseViewModel<AuthorSelectAction, AuthorSelectState, AuthorSelectResult>(
    actionReducer = AuthorSelectActionReducer(),
    resultReducer = AuthorSelectResultReducer(),
    useCaseSet = useCaseSet,
    initialState = AuthorSelectState(),
    router = router
) {
    fun authorClick(author: AuthorUI, select: Boolean) {
        action(AuthorSelectAction.AuthorClicks(author, select))
    }

    init {
        action(AuthorSelectAction.LoadAuthors)
    }
}
