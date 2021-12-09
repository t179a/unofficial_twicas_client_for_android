package com.example.unofficial_twicas_client_for_android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AuthorizationViewModel: ViewModel() {
    private val Redirect_url: String = "hoge://huga"
    private val ClientSecret: String = "4e9ed5aff4c6f30ca690205d47531d557dbabd11da9a30662f912665e39fe88d"
    private val ClientId: String = "ct179a.9e451f164079ffa6a2589cfe1af12275cd8030dfc727795f338c354b0bb00f5a"

    private val _authorizationProperty = MutableLiveData<AuthorizationProperty?>()
    val authorizationProperty: LiveData<AuthorizationProperty?>
        get() = _authorizationProperty



    fun getTwicasAuthorizationProperty(code: String){
            viewModelScope.launch(Dispatchers.IO) {
                val options: MutableMap<String, String> = mutableMapOf()
                options["code"] = code
                options["grant_type"] = "authorization_code"
                options["client_id"] = ClientId
                options["client_secret"] = ClientSecret
                options["redirect_uri"] = Redirect_url
                try {
                    _authorizationProperty.postValue(
                        TwicasApi.retrofitService.getAccessToken(options))
                }catch (e: Exception){
                    Log.d("hogehoge", e.message!!)
                    _authorizationProperty.postValue(AuthorizationProperty("error", -1, "error"))
                }
        }
    }

}