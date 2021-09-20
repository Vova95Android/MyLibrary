package com.example.mylibrary.di

import com.example.mylibrary.ui.activity.MainViewModel
import com.example.mylibrary.ui.authors.addAuthors.AddAuthorsViewModel
import com.example.mylibrary.ui.authors.addAuthors.usecase.SaveAuthorUseCase
import com.example.mylibrary.ui.authors.authorList.AuthorListViewModel
import com.example.mylibrary.ui.authors.authorList.usecase.LoadAuthorListUseCase
import com.example.mylibrary.ui.authors.detailAuthor.DetailAuthorViewModel
import com.example.mylibrary.ui.authors.detailAuthor.usecase.LoadCurrentAuthorUseCase
import com.example.mylibrary.ui.books.addBook.AddBookViewModel
import com.example.mylibrary.ui.books.addBook.usecase.AddNewBookUseCase
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.AuthorSelectViewModel
import com.example.mylibrary.ui.books.addBook.dialogAuthorSelect.usecase.AuthorSelectLoadAuthorSelectUseCase
import com.example.mylibrary.ui.books.addBook.usecase.AddBookLoadAuthorListUseCase
import com.example.mylibrary.ui.books.booksList.BookListViewModel
import com.example.mylibrary.ui.books.booksList.usecase.LoadBookListUseCase
import com.example.mylibrary.ui.books.detailBook.DetailBookViewModel
import com.example.mylibrary.ui.books.detailBook.usecase.LoadCurrentBookUseCase
import com.example.mylibrary.ui.start.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(get(globalRouter()))
    }
    viewModel {
        AddAuthorsViewModel(
            useCaseSet = setOf(
                get<SaveAuthorUseCase>()
            ),
            get(authorsRouter())
        )
    }
    viewModel {
        AuthorListViewModel(
            useCaseSet = setOf(
                get<LoadAuthorListUseCase>(),
            ),
            get(authorsRouter())
        )
    }
    viewModel {
        AddBookViewModel(
            useCaseSet = setOf(
                get<AddBookLoadAuthorListUseCase>(),
                get<AddNewBookUseCase>()
            ),
            get(booksRouter())
        )
    }
    viewModel {
        BookListViewModel(
            useCaseSet = setOf(
                get<LoadBookListUseCase>()
            ),
            get(booksRouter())
        )
    }
    viewModel {
        AuthorSelectViewModel(
            useCaseSet = setOf(
                get<AuthorSelectLoadAuthorSelectUseCase>()
            ),
            get(booksRouter())
        )
    }
    viewModel {
        StartViewModel(
            useCaseSet = setOf(),
            get(globalRouter())
        )
    }
    viewModel { (bookId: String)->
        DetailBookViewModel(
            useCaseSet = setOf(
                get<LoadCurrentBookUseCase>()
            ),
            get(globalRouter()),
            bookId
        )
    }
    viewModel { (authorId: String)->
        DetailAuthorViewModel(
            useCaseSet = setOf(
                get<LoadCurrentAuthorUseCase>()
            ),
            get(globalRouter()),
            authorId
        )
    }
}
