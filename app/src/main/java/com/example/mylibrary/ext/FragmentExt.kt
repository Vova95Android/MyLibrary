package com.example.mylibrary.ext

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard(){
    val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE)
    if (imm is InputMethodManager)
        imm.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
}