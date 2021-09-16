package com.example.mylibrary.ui.model

import com.example.mylibrary.data.model.AuthorModel
import java.util.*

data class AuthorUI(
    val id: String = UUID.randomUUID().toString(),
    val fistName: String,
    val lastName: String,
    val dateOfBirth: String,
    val genres: List<String>,
    val bookIds: List<String>,
    val isChecked: Boolean = false
) {

    fun toModel(): AuthorModel {
        return AuthorModel(
            id = id,
            fistName = fistName,
            lastName = lastName,
            dateOfBirth = dateOfBirth,
            genres = genres,
            bookIds = bookIds
        )
    }

    companion object {
        fun fromModel(author: AuthorModel): AuthorUI {
            return AuthorUI(
                id = author.id,
                fistName = author.fistName,
                lastName = author.lastName,
                dateOfBirth = author.dateOfBirth,
                genres = author.genres,
                bookIds = author.bookIds
            )
        }
    }
}
