package com.example.mylibrary.ui.authors.authorList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.databinding.ItemAuthorBinding
import com.example.mylibrary.ui.authors.model.AuthorUI

class AuthorListAdapter(
    private val clickListener: (AuthorUI)->Unit
) : ListAdapter<AuthorUI, AuthorListAdapter.ViewHolder>(AuthorListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAuthorBinding.inflate(
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
        private val binding: ItemAuthorBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(author: AuthorUI, clickListener: (AuthorUI)->Unit) {
            with(binding) {
                authorName.text = author.fistName
                authorLastname.text = author.lastName
                authorDateOfBirsd.text = author.dateOfBirth
                root.setOnClickListener {
                    clickListener.invoke(author)
                }
            }
        }
    }
}

private class AuthorListDiffCallback : DiffUtil.ItemCallback<AuthorUI>() {

    override fun areItemsTheSame(oldItem: AuthorUI, newItem: AuthorUI): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AuthorUI, newItem: AuthorUI): Boolean {
        return oldItem.id == newItem.id
    }
}