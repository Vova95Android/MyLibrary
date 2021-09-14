package com.example.mylibrary.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseListAdapter<D, V : BaseViewHolder<D, VB>, VB : ViewBinding>(diff: DiffUtil.ItemCallback<D>) : ListAdapter<D, V>(diff) {

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V {
        return onCreateViewHolder(
            createBindingInstance(LayoutInflater.from(parent.context), parent),
            viewType
        )
    }

    @Suppress("UNCHECKED_CAST")
    private fun createBindingInstance(inflater: LayoutInflater, container: ViewGroup?): VB {
        val vbClass = bindingClass()
        val method = vbClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        return method.invoke(null, inflater, container, false) as VB
    }

    @Suppress("UNCHECKED_CAST")
    private fun bindingClass(): Class<*> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[2] as Class<*>)
    }

    abstract fun onCreateViewHolder(itemView: VB, viewType: Int): V

    override fun onBindViewHolder(holder: V, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            holder.onBind(getItem(position), payloads)
        }
    }

    override fun onViewRecycled(holder: V) {
        holder.onRecycled()
    }
}