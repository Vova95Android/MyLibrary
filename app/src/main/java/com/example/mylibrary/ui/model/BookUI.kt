package com.example.mylibrary.ui.model

import com.example.mylibrary.data.model.BookModel

data class BookUI(
    val id: String,
    val title: String,
    val descriptions: String,
    val authorIds: List<String>,
    val genres: List<String>,
    val titleIcon: Int,
    val rating: Int
) {

    fun toModel(): BookModel {
        return BookModel(
            id = id,
            title = title,
            descriptions = descriptions,
            authorIds = authorIds,
            genres = genres,
            titleIcon = titleIcon,
            rating = rating
        )
    }

    companion object {
        fun fromModel(book: BookModel): BookUI {
            return BookUI(
                id = book.id,
                title = book.title,
                descriptions = book.descriptions,
                authorIds = book.authorIds,
                genres = book.genres,
                titleIcon = book.titleIcon,
                rating = book.rating
            )
        }
    }
}
