package com.ankit.trendinggit.view.ui.myRepoList

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ankit.trendinggit.view.ui.ReposHostFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ReposHostFragment.newInstance("TRENDING")
            }
            1 -> ReposHostFragment.newInstance("OWN")
            else -> {
                return MyRepoListFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Repo list"
            1 -> "My Repo list"
            else -> {
                return "Third Tab"
            }
        }
    }
}