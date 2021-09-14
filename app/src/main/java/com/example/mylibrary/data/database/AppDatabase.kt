package com.example.mylibrary.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mylibrary.data.database.dao.AuthorDao
import com.example.mylibrary.data.database.model.AuthorEntity
import com.example.mylibrary.data.database.model.BookEntity

@Database(
    entities = [
        AuthorEntity::class,
        BookEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun authorDao(): AuthorDao
}