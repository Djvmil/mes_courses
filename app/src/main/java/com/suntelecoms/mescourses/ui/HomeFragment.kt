package com.suntelecoms.mescourses.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.djamil.utils.onClick
import com.suntelecoms.mescourses.R
import com.suntelecoms.mescourses.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment() {

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
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.course_cv.onClick{
            activityParent.loadFragment(ShoppingListFragment())
        }

        view.archive_cv.onClick {
            activityParent.loadFragment(ArchiveFragment())
        }

        view.profile_cv.onClick {
            activityParent.loadFragment(ProfileFragment())
        }

        return view
    }
}