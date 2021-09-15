package com.example.mylibrary.di

import com.example.mylibrary.ui.activity.MainViewModel
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorsViewModel
import com.example.mylibrary.ui.authors.addAuthors.usecase.SaveAuthorUseCase
import com.example.mylibrary.ui.authors.authorList.AuthorListViewModel
import com.example.mylibrary.ui.authors.authorList.usecase.LoadAuthorListUseCase
import com.example.mylibrary.ui.books.addBook.AddBookViewModel
import com.example.mylibrary.ui.books.addBook.dialogAddBook.usecase.AddNewBookUseCase
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectViewModel
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.usecase.AuthorSelectLoadAuthorSelectUseCase
import com.example.mylibrary.ui.books.addBook.usecase.AddBookLoadAuthorListUseCase
import com.example.mylibrary.ui.books.booksList.BookListViewModel
import com.example.mylibrary.ui.start.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(get())
    }
    viewModel {
        AddAuthorsViewModel(
            useCaseSet = setOf(
                get<SaveAuthorUseCase>()
            ),
            get()
        )
    }
    viewModel {
        AuthorListViewModel(
            useCaseSet = setOf(
                get<LoadAuthorListUseCase>(),
            ),
            get()
        )
    }
    viewModel {
        AddBookViewModel(
            useCaseSet = setOf(
                get<AddBookLoadAuthorListUseCase>(),
                get<AddNewBookUseCase>()
            ),
            get()
        )
    }
    viewModel {
        BookListViewModel(
            useCaseSet = setOf(),
            get()
        )
    }
    viewModel {
        AuthorSelectViewModel(
            useCaseSet = setOf(
                get<AuthorSelectLoadAuthorSelectUseCase>()
            ),
            get()
        )
    }
    viewModel {
        StartViewModel(
            useCaseSet = setOf(),
            get()
        )
    }
}
