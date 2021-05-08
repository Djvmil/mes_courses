package com.suntelecoms.mescourses

import android.os.Bundle
import com.suntelecoms.mescourses.core.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}