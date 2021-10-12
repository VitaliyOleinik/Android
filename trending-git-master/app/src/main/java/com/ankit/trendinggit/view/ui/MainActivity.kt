package com.ankit.trendinggit.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.ankit.trendinggit.R
import com.ankit.trendinggit.view.ui.myRepoList.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.main_nav_fragment))
//        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
//        viewpager_main.adapter = fragmentAdapter
//        tabs_main.setupWithViewPager(viewpager_main)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()
}