package com.example.mylibrary.ui.authors.addAuthors.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibrary.R
import com.example.mylibrary.databinding.ItemGenresBinding

class GenresAdapter(
    private val clickListener: (GenresItem) -> Unit
) : ListAdapter<GenresItem, GenresAdapter.ViewHolder>(BookListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGenresBinding.inflate(
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
        private val binding: ItemGenresBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GenresItem, clickListener: (GenresItem) -> Unit) {
            with(binding) {
                addGenre.setOnClickListener { clickListener.invoke(item.copy(textNewGenre.text.toString())) }
                if (item.name != null) {
                    genresName.text = item.name
                    addGenre.isVisible = false
                    textNewGenre.isVisible = false
                } else {
                    addGenre.isVisible = true
                    textNewGenre.isVisible = true
                    genresName.text = genresName.context.getText(R.string.add_ganres)
                }
            }
        }
    }
}

private class BookListDiffCallback : DiffUtil.ItemCallback<GenresItem>() {

    override fun areItemsTheSame(oldItem: GenresItem, newItem: GenresItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: GenresItem, newItem: GenresItem): Boolean {
        return oldItem.name == newItem.name
    }
}

data class GenresItem(
    val name: String? = null,
    val newGenre: Boolean = false
)
