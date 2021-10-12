package com.ankit.trendinggit.view.ui.myRepoList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankit.trendinggit.databinding.FragmentMyRepoListBinding
import com.ankit.trendinggit.view.adapter.RepoListAdapter
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.jetbrains.anko.longToast
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyRepoListFragment : Fragment() {

    private lateinit var adapter: RepoListAdapter
    private lateinit var viewDataBinding: FragmentMyRepoListBinding
    private val repoViewModel by viewModel<MyRepoListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = FragmentMyRepoListBinding.inflate(inflater, container, false)
            .apply {
            viewmodel = repoViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchMyRepoList()
        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        viewDataBinding.viewmodel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

        viewDataBinding.viewmodel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            activity?.longToast(it)
        })
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = RepoListAdapter()
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            repo_list_rv.adapter = adapter
        }
    }
}
