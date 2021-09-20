package com.example.mylibrary.di

import com.example.mylibrary.ui.authors.addAuthors.usecase.SaveAuthorUseCase
import com.example.mylibrary.ui.authors.authorList.usecase.LoadAuthorListUseCase
import com.example.mylibrary.ui.authors.detailAuthor.usecase.LoadCurrentAuthorUseCase
import com.example.mylibrary.ui.books.addBook.usecase.AddNewBookUseCase
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.usecase.AuthorSelectLoadAuthorSelectUseCase
import com.example.mylibrary.ui.books.addBook.usecase.AddBookLoadAuthorListUseCase
import com.example.mylibrary.ui.books.booksList.usecase.LoadBookListUseCase
import com.example.mylibrary.ui.books.detailBook.usecase.LoadCurrentBookUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SaveAuthorUseCase(get()) }
    factory { LoadAuthorListUseCase(get()) }
    factory { AddBookLoadAuthorListUseCase(get()) }
    factory { AuthorSelectLoadAuthorSelectUseCase(get()) }
    factory { AddNewBookUseCase(get()) }
    factory { LoadBookListUseCase(get()) }
    factory { LoadCurrentBookUseCase(get(), get()) }
    factory { LoadCurrentAuthorUseCase(get()) }
}
