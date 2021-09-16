package com.example.mylibrary.ui.books.booksList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.databinding.ItemBookBinding
import com.example.mylibrary.ui.model.BookUI

class BookListAdapter(
    private val clickListener: (BookUI) -> Unit
) : ListAdapter<BookUI, BookListAdapter.ViewHolder>(BookListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class ViewHolder(
        private val binding: ItemBookBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: BookUI, clickListener: (BookUI) -> Unit) {
            with(binding) {
                bookTitle.text = book.title
                bookDescriptions.text = book.descriptions
                imageTitle.setImageResource(book.titleIcon)
                root.setOnClickListener { clickListener.invoke(book) }
            }
        }
    }
}

private class BookListDiffCallback : DiffUtil.ItemCallback<BookUI>() {

    override fun areItemsTheSame(oldItem: BookUI, newItem: BookUI): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BookUI, newItem: BookUI): Boolean {
        return oldItem.id == newItem.id
    }
}
