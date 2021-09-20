package com.example.mylibrary.ui.authors.authorList

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.authors.addAuthors.ScreenAddAuthors
import com.example.mylibrary.ui.authors.authorList.reducer.AuthorListsActionReducer
import com.example.mylibrary.ui.authors.authorList.reducer.AuthorListsResultReducer
import com.example.mylibrary.ui.authors.detailAuthor.ScreenDetailAuthor

class AuthorListViewModel(
    useCaseSet: Set<UseCase<AuthorListAction, AuthorListState, AuthorListResult>>,
    router: Router
) : BaseViewModel<AuthorListAction, AuthorListState, AuthorListResult>(
    actionReducer = AuthorListsActionReducer(),
    resultReducer = AuthorListsResultReducer(),
    useCaseSet = useCaseSet,
    initialState = AuthorListState(),
    router = router
) {
    fun toAddAuthors() {
        router.replace(ScreenAddAuthors())
    }

    fun loadAuthorList() {
        action(AuthorListAction.LoadAuthors)
    }

    fun toDetailAuthor(authorId: String) {
        router.replace(ScreenDetailAuthor(authorId))
    }
}
