package com.suntelecoms.mescourses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.djamil.utils.onClick
import com.suntelecoms.mescourses.R
import kotlinx.android.synthetic.main.fragment_archive.view.*

class ProfileFragment : Fragment() {

    lateinit var activityParent: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityParent = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_archive, container, false)
        view.imgMenuBackImageView.onClick {
            activityParent.loadFragment(HomeFragment())
        }
        return view
    }
}