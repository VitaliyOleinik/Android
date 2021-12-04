package com.ankit.trendinggit.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.ankit.trendinggit.R


class ReposHostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_repos_host, container, false)
        val type = arguments?.getString(TAB_TYPE)

        val master = childFragmentManager.findFragmentById(R.id.master_nav_fragment) as NavHostFragment?
        if(master != null){
            val navController = master.navController
            val navInflater = navController.navInflater
            if(type == "TRENDING"){
                val graph = navInflater.inflate(R.navigation.tren_repo_nav)
                master.navController.graph = graph
            }
            else{
                val graph = navInflater.inflate(R.navigation.own_repo_nav)
                master.navController.graph = graph
            }
        }

        return rootView
    }


    companion object {
        val TAB_TYPE = "tab_type"

        fun newInstance(tabType: String): ReposHostFragment {
            val fragment = ReposHostFragment()
            val bundle = Bundle()
            bundle.putString(TAB_TYPE, tabType)
            fragment.arguments = bundle

            return fragment
        }
    }
}
