package com.suntelecoms.mescourses.ui

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.suntelecoms.mescourses.AppClass
import com.suntelecoms.mescourses.R
import com.suntelecoms.mescourses.core.BaseActivity

class HomeActivity : BaseActivity() {
    private val mHomeFragment = HomeFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState == null) {
            loadFragment(mHomeFragment)
        }
    }


    fun loadFragment(fragment: Fragment, @IdRes id: Int = -1) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_Container, fragment).commit()
    }


    override fun onBackPressed() {
        for (backPressListener in AppClass.getAppInstance().backPressListeners)
            if (backPressListener.onBackPress()) return

        showAlertDialog(getString(R.string.app_name),
            getString(R.string.msg_quit_app),
            ALERT_TYPE_WARNING,
            true,
            false,
            { super.onBackPressed() },
            {}
        )
    }


}