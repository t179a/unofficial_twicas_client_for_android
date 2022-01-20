package com.example.unofficial_twicas_client_for_android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class RecommendListViewModel(val accessToken: String): ViewModel() {
    val movieList:MutableLiveData<Movies> = MutableLiveData(Movies(emptyList()))
    val state: MutableLiveData<Boolean> = MutableLiveData(false)
    //val teststate: MutableLiveData<String> = MutableLiveData("hoge")
    //val fetched:MutableLiveData<String> = MutableLiveData("hoge")

    init {
        getRecommendList()
    }

    fun getRecommendList(){
        viewModelScope.launch {
            //teststate.value = accessToken
            val options: MutableMap<String, String> = mutableMapOf()
            options["Accept"] = "application/json"
            options["X-Api-Version"] = "2.0"
            options["Authorization"] = "Bearer ${accessToken}"
            //"gzipすると型が合わなくなる
            //options["Accept-Encoding"] = "gzip"
            try {
                movieList.value = TwicasApi.retrofitService.searchLiveMovies(options)
                //fetched.value = "success"
                Log.d("getRecommendList", "success")
            }catch (e: Exception){
                Log.d("getRecommendList", e.message!!)
                //state.value = true
            }
        }
    }
}