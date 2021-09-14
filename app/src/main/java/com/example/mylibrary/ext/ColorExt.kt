package com.example.mylibrary.ext

import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Context.color(@ColorRes id: Int) = ContextCompat.getColor(this, id)

fun Fragment.color(@ColorRes id: Int) = ContextCompat.getColor(requireContext(), id)

fun View.color(@ColorRes id: Int) = ContextCompat.getColor(context, id)

fun View.setBackgroundColorRes(@ColorRes res: Int) {
    setBackgroundColor(ContextCompat.getColor(context, res))
}
