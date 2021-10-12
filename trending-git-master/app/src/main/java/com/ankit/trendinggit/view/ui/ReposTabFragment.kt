package com.ankit.trendinggit.view.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ankit.trendinggit.R
import com.ankit.trendinggit.view.ui.myRepoList.MyPagerAdapter
import kotlinx.android.synthetic.main.fragment_repos_tab.*

class ReposTabFragment : Fragment(R.layout.fragment_repos_tab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentAdapter = MyPagerAdapter(childFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)
    }
}