package com.suntelecoms.mescourses.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.djamil.utils.onClick
import com.suntelecoms.mescourses.R
import kotlinx.android.synthetic.main.fragment_archive.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShoppingListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoppingListFragment : Fragment() {

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
        imgMenuBackImageView.onClick {
            activityParent.loadFragment(HomeFragment())
        }
        return view
    }

}