package com.example.mylibrary.data.model

import com.example.mylibrary.data.database.model.BookEntity
import java.util.*

data class BookModel (
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val descriptions: String,
    val authorIds: List<String>,
    val genres: List<String>,
    val titleIcon: Int,
    val rating: Int
) {

    fun toEntity(): BookEntity{
        return BookEntity(
            id = id,
            title = title,
            descriptions = descriptions,
            authorIds = authorIds,
            genres = genres,
            titleIcon = titleIcon,
            rating = rating
        )
    }

    companion object{
        fun fromEntity(book: BookEntity): BookModel{
            return BookModel(
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
