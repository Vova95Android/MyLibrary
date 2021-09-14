package com.example.mylibrary.base

import android.os.Build
import android.os.Looper
import android.util.Log
import androidx.annotation.CallSuper
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.example.mylibrary.base.mvi.Reducer
import com.example.mylibrary.base.mvi.UseCase
import com.example.mylibrary.navigation.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModel<Action, State, Result>(
    private val actionReducer: Reducer<Action, State>,
    private val resultReducer: Reducer<Result, State>,
    private val useCaseSet: Set<UseCase<Action, State, Result>>,
    private val initialState: State
) : ViewModel(), LifecycleObserver {

    private val mutableStateLiveData = MutableLiveData(initialState)
    val stateLiveData: LiveData<State>
        get() = mutableStateLiveData

    private val mutableErrorLiveData = MutableLiveData<String>()
    val errorObservable: LiveData<String>
        get() = mutableErrorLiveData

    var sideEffect: List<LiveData<Result>> = emptyList()
    private val disposable = CompositeDisposable()

    @RequiresApi(Build.VERSION_CODES.P)
    private val baseErrorHandler =
        android.os.Handler.createAsync(Looper.getMainLooper()) { message ->
            Log.e("ViewModel exception", message.toString())
            mutableErrorLiveData.postValue(message.toString())
            mutableStateLiveData.postValue(initialState)
            true
        }

    lateinit var router: Router

    init {

        sideEffect = useCaseSet.map { it.sideEffectLiveData }
    }

    fun action(action: Action) {
        val state = actionReducer(action, mutableStateLiveData.value ?: initialState)
        mutableStateLiveData.postValue(state)
        Flowable.fromIterable(useCaseSet)
            .subscribeOn(Schedulers.io())
            .filter { it.canHandle(action) }
            .map {
                it.map(action, stateLiveData.value?: initialState)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mutableStateLiveData.postValue(resultReducer(it, stateLiveData.value?: initialState))
            }, {
                it.printStackTrace()
            }).disposeOnClear()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreateView() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun onPause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @CallSuper
    open fun onDestroyView() {

    }

    protected fun Disposable.disposeOnClear() {
        disposable.add(this)
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}