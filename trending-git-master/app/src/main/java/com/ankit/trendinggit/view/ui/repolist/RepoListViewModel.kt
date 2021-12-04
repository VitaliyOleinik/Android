package com.ankit.trendinggit.view.ui.repolist

import androidx.lifecycle.MutableLiveData
import com.ankit.trendinggit.model.Item
import com.ankit.trendinggit.model.RepoRepository
import com.ankit.trendinggit.view.base.BaseViewModel

class RepoListViewModel(private val repoRepository: RepoRepository) : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList() {
        dataLoading.value = true
        repoRepository.getRepoList { isSuccess, response ->
            if (isSuccess) {
                repoListLive.value = response?.items
                dataLoading.value = false
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}