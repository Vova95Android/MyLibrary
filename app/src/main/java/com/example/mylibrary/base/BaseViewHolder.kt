package com.example.mylibrary.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T, VB: ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(data: T)

    open fun onBind(data: T, payloads: List<Any>) {

    }

    open fun onRecycled() {

    }
}