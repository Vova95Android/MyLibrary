package com.example.mylibrary.ui.authors.authorList

import com.example.mylibrary.ui.model.AuthorUI

data class AuthorListState(
    val isLoading: Boolean = false,
    val authors: List<AuthorUI> = emptyList()
)
