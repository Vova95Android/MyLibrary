package com.example.mylibrary.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mylibrary.databinding.CustomStarTextBinding

class StarText(
    context: Context,
    attributeSet: AttributeSet
) : ConstraintLayout(context, attributeSet) {

    private val binding = CustomStarTextBinding.inflate(LayoutInflater.from(context), this, true)
    var text: String = "0"
        set(value) {
            field = value
            binding.textRating.text = value
        }

}