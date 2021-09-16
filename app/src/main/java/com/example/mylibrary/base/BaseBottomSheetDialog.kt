package com.example.mylibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import com.example.mylibrary.R
import com.example.mylibrary.ext.color
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.DefinitionParameters
import org.koin.core.parameter.emptyParametersHolder
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseBottomSheetDialog<VM : BaseViewModel<*, *, *>, VB : ViewBinding>: BottomSheetDialogFragment(){
    private var _binding: VB? = null

    protected open val viewModel: VM by lazy {
        getViewModel(
            clazz = viewModelKClass(),
            parameters = parameters()
        )
    }

    abstract fun subscribeOnState()

    private val statusBarHeight by lazy {
        return@lazy try {
            var result = 0
            val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = resources.getDimensionPixelSize(resourceId)
            }
            result
        } catch (exc: Exception) {
            0
        }
    }

    private var progressBar: LinearProgressIndicator? = null

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

    open fun parameters(): () -> DefinitionParameters = {
        emptyParametersHolder()
    }

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
        progressBar = null
        _binding = null
    }

    open fun onBackPressed(): Boolean? {
        return true
    }

    open fun showError(message: String?) {
        val view = view ?: return
        Snackbar.make(view, message ?: getString(R.string.some_error), Snackbar.LENGTH_LONG)
            .setBackgroundTint(color(R.color.error))
            .show()
    }
}
