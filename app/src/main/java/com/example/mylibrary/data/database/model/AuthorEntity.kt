package com.example.mylibrary.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mylibrary.di.ListConverter
import java.util.*

@Entity
@TypeConverters(ListConverter::class)
data class AuthorEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val fistName: String,
    val lastName: String,
    val dateOfBirth: String,
    val genres: List<String>,
    val bookIds: List<String>
)