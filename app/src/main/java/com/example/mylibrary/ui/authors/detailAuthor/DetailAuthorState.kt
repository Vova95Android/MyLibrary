package com.example.mylibrary.ui.authors.detailAuthor

import com.example.mylibrary.ui.model.AuthorUI

data class DetailAuthorState(
    val isLoading: Boolean = false,
    val authorItem: AuthorUI? = null
)
