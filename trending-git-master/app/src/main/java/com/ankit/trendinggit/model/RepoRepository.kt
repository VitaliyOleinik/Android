package com.ankit.trendinggit.model

import com.ankit.trendinggit.model.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRepository(private val apiService: ApiService) {

    // GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: GitResponse?) -> Unit) {

        apiService.getRepo().enqueue(object : Callback<GitResponse> {
            override fun onResponse(call: Call<GitResponse>?, response: Response<GitResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<GitResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    fun getMyRepoList(onResult: (isSuccess: Boolean, response: List<Item>?) -> Unit) {

        apiService.getMyRepo().enqueue(object : Callback<List<Item>> {
            override fun onResponse(p0: Call<List<Item>>, response: Response<List<Item>>) {
                if (response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(p0: Call<List<Item>>, p1: Throwable) {
                onResult(false, null)
            }
        })
    }
}