package com.ankit.trendinggit.view.ui.myRepoList

import androidx.lifecycle.MutableLiveData
import com.ankit.trendinggit.model.Item
import com.ankit.trendinggit.model.RepoRepository
import com.ankit.trendinggit.view.base.BaseViewModel
import com.ankit.trendinggit.view.ui.repolist.RepoListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyRepoListViewModel(private val repoRepository: RepoRepository) : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchMyRepoList() {
        dataLoading.value = true
        repoRepository.getMyRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}