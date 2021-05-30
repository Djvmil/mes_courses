package com.suntelecoms.mescourses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.djamil.utils.onClick
import com.suntelecoms.mescourses.R
import com.suntelecoms.mescourses.core.BaseFragment
import kotlinx.android.synthetic.main.bank_title_item_layout.view.*

class ProfileFragment : BaseFragment() {

    lateinit var activityParent: HomeActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityParent = activity as HomeActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_archive, container, false)

        view.txtMenuItemTitle.text = "Profil"
        view.imgMenuBackImageView.onClick {
            activityParent.loadFragment(HomeFragment())
        }
        return view
    }
}