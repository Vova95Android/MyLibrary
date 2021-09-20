package com.example.mylibrary.ui.authors.detailAuthor

import com.example.mylibrary.base.BaseViewModel
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.navigation.Router
import com.example.mylibrary.ui.authors.detailAuthor.reducer.DetailAuthorActionReducer
import com.example.mylibrary.ui.authors.detailAuthor.reducer.DetailAuthorResultReducer

class DetailAuthorViewModel(
    useCaseSet: Set<UseCase<DetailAuthorAction, DetailAuthorState, DetailAuthorResult>>,
    router: Router,
    authorId: String
) : BaseViewModel<DetailAuthorAction, DetailAuthorState, DetailAuthorResult>(
    actionReducer = DetailAuthorActionReducer(),
    resultReducer = DetailAuthorResultReducer(),
    useCaseSet = useCaseSet,
    initialState = DetailAuthorState(),
    router = router
) {

    init {
        action(DetailAuthorAction.GetCurrentAuthor(authorId))
    }
}
