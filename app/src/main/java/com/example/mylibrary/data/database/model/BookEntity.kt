package com.example.mylibrary.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mylibrary.di.ListConverter
import java.util.*

@Entity
@TypeConverters(ListConverter::class)
data class BookEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val descriptions: String,
    val authorIds: List<String>,
    val genres: List<String>,
    val titleIcon: Int,
    val rating: Int
)
