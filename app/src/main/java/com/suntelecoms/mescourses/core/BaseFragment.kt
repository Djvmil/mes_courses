package com.suntelecoms.mescourses.core

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.suntelecoms.mescourses.AppClass
import com.suntelecoms.mescourses.helpers.IOnBackPressed
import kotlinx.android.synthetic.main.bank_title_item_layout.*

/**
 * @Author Moustapha S. Dieme ( Djvmil_ ) on 8/15/20
 */
open class BaseFragment : Fragment(), IOnBackPressed {

    lateinit var activity: BaseActivity
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity)
            activity = context

        AppClass.getAppInstance().backPressListeners.add(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Search finish", "finish: 5" )
        AppClass.getAppInstance().backPressListeners.remove(this)
    }



    override fun onBackPress(): Boolean {
        // you should check that if this fragment is the currently used fragment or not
        // if this fragment is not used at the moment you should return false
        if(!isVisible)
            return false

        if (isVisible) {
            if(imgMenuBackImageView != null)
                imgMenuBackImageView.performClick()

            return true
        }
        return false
    }



}