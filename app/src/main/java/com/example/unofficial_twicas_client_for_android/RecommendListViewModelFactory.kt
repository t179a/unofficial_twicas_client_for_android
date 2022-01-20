package com.example.unofficial_twicas_client_for_android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class RecommendListViewModelFactory(private val accessToken: String): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RecommendListViewModel::class.java)){
            return RecommendListViewModel(accessToken) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}