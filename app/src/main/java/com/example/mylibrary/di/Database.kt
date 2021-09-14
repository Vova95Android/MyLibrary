package com.example.mylibrary.di

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import androidx.room.TypeConverter
import com.example.mylibrary.data.database.AppDatabase
import org.koin.dsl.module
import java.util.stream.Collectors

val databaseModule = module {

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, DATABASE_NAME).build()
    }

    single {
        get<AppDatabase>().authorDao()
    }
}

const val DATABASE_NAME = "MyLibraryDatabase"

class ListConverter {
    @RequiresApi(Build.VERSION_CODES.N)
    @TypeConverter
    fun fromList(list: List<String?>): String {
        return list.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toList(data: String): List<String> {
        return data.split(",".toRegex())
    }
}
