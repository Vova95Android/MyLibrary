package com.example.mylibrary.ui.authors.detailAuthor

sealed class DetailAuthorAction {

    data class GetCurrentAuthor(
        val authorId: String
    ) : DetailAuthorAction()
}
