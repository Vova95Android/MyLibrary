package com.example.mylibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.mylibrary.R
import com.example.mylibrary.ext.color
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.DefinitionParameters
import org.koin.core.parameter.emptyParametersHolder
import org.koin.core.parameter.parametersOf
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseFragment<VM : BaseViewModel<*, *, *>, VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null

    protected open val viewModel: VM by lazy {
        getViewModel(
            clazz = viewModelKClass(),
            parameters = {
                parametersOf(getParameters())
            }
        )
    }

    abstract fun subscribeOnState()

    protected val binding get() = _binding!!

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createBindingInstance(inflater, container).also { _binding = it }.root
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subscribeOnState()
        super.onViewCreated(view, savedInstanceState)
    }

    open fun getParameters(): Any? = null

    @Suppress("UNCHECKED_CAST")
    private fun viewModelKClass(): KClass<VM> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<VM>).kotlin
    }

    @Suppress("UNCHECKED_CAST")
    private fun bindingClass(): Class<*> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[1] as Class<*>)
    }

    @Suppress("UNCHECKED_CAST")
    private fun createBindingInstance(inflater: LayoutInflater, container: ViewGroup?): VB {
        val vbClass = bindingClass()
        val method = vbClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        return method.invoke(null, inflater, container, false) as VB
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    open fun onBackPressed(): Boolean {
        // return true if fragment needs to pop, false if not
        return true
    }

    open fun showError(message: String?) {
        val view = view ?: return
        Snackbar.make(view, message ?: getString(R.string.some_error), Snackbar.LENGTH_LONG)
            .setBackgroundTint(color(R.color.error))
            .show()
    }
}