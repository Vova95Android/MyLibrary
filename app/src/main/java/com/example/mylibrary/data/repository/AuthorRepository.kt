package com.example.mylibrary.data.repository

import com.example.mylibrary.data.database.dao.AuthorDao
import com.example.mylibrary.data.model.AuthorModel

interface AuthorRepository {

    fun saveNewAuthor(author: AuthorModel)
    fun getAuthorFromId(id: String): AuthorModel?
    fun getAuthorList(): List<AuthorModel>
}

class AuthorRepositoryImpl(
    private val authorDatabase: AuthorDao
) : AuthorRepository {
    override fun saveNewAuthor(author: AuthorModel) {
        authorDatabase.saveNewAuthor(author.toEntity())
    }

    override fun getAuthorFromId(id: String): AuthorModel? {
        val authorEntity = authorDatabase.getAuthorOrNull(id)
        return authorEntity?.let { AuthorModel.fromEntity(it) }
    }

    override fun getAuthorList(): List<AuthorModel> {
        val authorEntityList = authorDatabase.getAllAuthors()
        return authorEntityList.map { AuthorModel.fromEntity(it) }
    }
}