package com.example.mylibrary.data.database.dao

import androidx.room.*
import com.example.mylibrary.data.database.model.BookEntity

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNewBook(bookEntity: BookEntity)

    @Query("SELECT * FROM BookEntity ORDER BY title ASC")
    fun getAllBook(): List<BookEntity>

    @Transaction
    @Query("SELECT * FROM BookEntity WHERE id = :id")
    fun getBookOrNull(id: String): BookEntity?

}