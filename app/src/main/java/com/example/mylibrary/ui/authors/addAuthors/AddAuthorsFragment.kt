package com.example.mylibrary.ui.authors.addAuthors

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.databinding.FragmentAddAuthorsBinding

class AddAuthorsFragment : BaseFragment<AddAuthorsViewModel, FragmentAddAuthorsBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            authorDateOfBirth.setOnClickListener {
                val dateDialog = DatePickerDialog(requireContext())
                dateDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                    viewModel.setDateOfBirth(year, month, dayOfMonth)
                }
                dateDialog.show()
            }
            authorFirstName.doOnTextChanged { text, _, _, _ ->
                if (text != null) {
                    viewModel.firstNameChanged(text.toString())
                }
            }
            authorLastName.doOnTextChanged { text, _, _, _ ->
                if (text != null) {
                    viewModel.lastNameChanged(text.toString())
                }
            }
            buttonSaveAuthor.setOnClickListener {
                viewModel.saveAuthor()
            }
        }
    }

    override fun subscribeOnState() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            binding.apply {
                authorDateOfBirth.text = state.dateOfBirth
                authorDateOfBirthText.isVisible = state.dateOfBirth.isNotEmpty()
                authorFirstNameText.isVisible = state.fistName.isNotEmpty()
                authorLastNameText.isVisible = state.lastName.isNotEmpty()
                authorLastNameTextError.isVisible = state.validateError.lastNameIsEmpty
                authorFirstNameTextError.isVisible = state.validateError.firstNameIsEmpty
                authorDateOfBirthTextError.isVisible = state.validateError.dateOfBirthIsEmpty
                if (state.authorSaveSuccess) viewModel.pop()
            }
        }
    }

    companion object {
        fun newInstance() = AddAuthorsFragment()
    }
}
