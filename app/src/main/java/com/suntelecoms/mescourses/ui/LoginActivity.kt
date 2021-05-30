package com.suntelecoms.mescourses.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.suntelecoms.mescourses.R
import com.suntelecoms.mescourses.core.BaseActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //for changing status bar icon colors
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }
        setContentView(R.layout.activity_login)
    }

    fun onLoginViewClick(View: View?) {
        showProgressDialog()

        Handler().postDelayed({
            startActivity(Intent(this, RegisterActivity::class.java))
            overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.stay
            )
            finish()
            hideProgressDialog()
        }, 1000)
    }

    fun onLoginClick(View: View?) {

        showProgressDialog()

        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.stay
            )
            finish()
            hideProgressDialog()
        }, 1000)
    }
}