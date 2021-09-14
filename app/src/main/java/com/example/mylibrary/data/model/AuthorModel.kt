package com.example.mylibrary.data.model

import com.example.mylibrary.data.database.model.AuthorEntity
import java.util.*

data class AuthorModel(
    val id: String = UUID.randomUUID().toString(),
    val fistName: String,
    val lastName: String,
    val dateOfBirth: String,
    val genres: List<String>,
    val bookIds: List<String>
) {

    fun toEntity(): AuthorEntity {
        return AuthorEntity(
            id = id,
            fistName = fistName,
            lastName = lastName,
            dateOfBirth = dateOfBirth,
            genres = genres,
            bookIds = bookIds
        )
    }

    companion object {
        fun fromEntity(author: AuthorEntity): AuthorModel {
            return AuthorModel(
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
