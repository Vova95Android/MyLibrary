package com.example.mylibrary.ui.authors.detailAuthor.usecase

import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.data.repository.AuthorRepository
import com.example.mylibrary.ui.authors.detailAuthor.DetailAuthorAction
import com.example.mylibrary.ui.authors.detailAuthor.DetailAuthorResult
import com.example.mylibrary.ui.authors.detailAuthor.DetailAuthorState

class LoadCurrentAuthorUseCase(
    private val authorRepository: AuthorRepository
) : UseCase<DetailAuthorAction, DetailAuthorState, DetailAuthorResult>() {

    override fun map(action: DetailAuthorAction, state: DetailAuthorState): DetailAuthorResult {
        return try {
            val action = action as DetailAuthorAction.GetCurrentAuthor
            val authorItem = authorRepository.getAuthorFromId(action.authorId)
            if (authorItem != null) {
                DetailAuthorResult.LoadAuthorSuccess(
                    authorItem = authorItem
                )
            } else {
                DetailAuthorResult.LoadAuthorError("")
            }
        } catch (e: Exception) {
            DetailAuthorResult.LoadAuthorError(e.message)
        }
    }

    override fun canHandle(action: DetailAuthorAction): Boolean {
        return action is DetailAuthorAction.GetCurrentAuthor
    }
}
