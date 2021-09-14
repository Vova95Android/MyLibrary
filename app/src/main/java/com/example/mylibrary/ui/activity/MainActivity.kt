package com.example.mylibrary.ui.activity

import android.os.Bundle
import com.example.mylibrary.R
import com.example.mylibrary.base.BaseActivity
import com.example.mylibrary.base.BaseFragment
import com.example.mylibrary.navigation.Router
import org.koin.android.ext.android.inject
import com.example.mylibrary.ui.authors.authorList.ScreenAuthorList

class MainActivity : BaseActivity<MainViewModel>() {

    private val globalRouter by inject<Router>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        globalRouter.attach(supportFragmentManager)
        globalRouter.replace(ScreenAuthorList())
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer) as? BaseFragment<*, *> ?: return
        if (fragment.onBackPressed() == true) {
            if (supportFragmentManager.backStackEntryCount > 1) {
                globalRouter.pop()
            } else {
                finish()
            }
        }
    }
}