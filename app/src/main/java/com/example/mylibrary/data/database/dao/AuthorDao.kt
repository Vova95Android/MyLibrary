package com.example.mylibrary.data.database.dao

import androidx.room.*
import com.example.mylibrary.data.database.model.AuthorEntity

@Dao
interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNewAuthor(authorEntity: AuthorEntity)

    @Query("SELECT * FROM AuthorEntity ORDER BY lastName ASC")
    fun getAllAuthors(): List<AuthorEntity>

    @Transaction
    @Query("SELECT * FROM AuthorEntity WHERE id = :id")
    fun getAuthorOrNull(id: String): AuthorEntity?

}