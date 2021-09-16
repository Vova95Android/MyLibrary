package com.example.mylibrary.ui.books.addBook

sealed class AddBookAction {

    data class SetBookName(
        val name: String
    ) : AddBookAction()

    data class SetBookDescriptions(
        val descriptions: String
    ) : AddBookAction()

    data class SetBookAuthorsId(
        val authors: List<String>
    ) : AddBookAction()

    data class SetBookTitle(val title: Int) : AddBookAction()
    object AddNewBook : AddBookAction()
}
