package com.example.mylibrary.data.repository

import com.example.mylibrary.data.database.dao.BookDao
import com.example.mylibrary.data.model.BookModel

interface BookRepository {

    fun saveNewBook(author: BookModel)
    fun getBookFromId(id: String): BookModel?
    fun getBookList(): List<BookModel>

}

class BookRepositoryImpl(
    private val bookDao: BookDao
): BookRepository{
    override fun saveNewBook(author: BookModel) {
        bookDao.saveNewBook(author.toEntity())
    }

    override fun getBookFromId(id: String): BookModel? {
        val bookEntity = bookDao.getBookOrNull(id)
        return bookEntity?.let { BookModel.fromEntity(it) }
    }

    override fun getBookList(): List<BookModel> {
        val bookEntityList = bookDao.getAllBook()
        return bookEntityList.map { BookModel.fromEntity(it) }
    }
}
