package com.example.unofficial_twicas_client_for_android

import android.content.ComponentCallbacks
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.unofficial_twicas_client_for_android.databinding.ActivityAuthorizationBinding
import java.lang.Exception

class AuthorizationActivity : AppCompatActivity() {
    private val ClientId: String = "ct179a.9e451f164079ffa6a2589cfe1af12275cd8030dfc727795f338c354b0bb00f5a"
    private val AuthorizationURL: String = "https://apiv2.twitcasting.tv/oauth2/authorize?client_id=${ClientId}&response_type=code"


    private lateinit var authorizationProperty: AuthorizationProperty

    private lateinit var binding: ActivityAuthorizationBinding

    private val viewModel: AuthorizationViewModel by lazy {
        ViewModelProvider(this).get(AuthorizationViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationBinding.inflate(layoutInflater)
        binding.loginButton.setOnClickListener {
            openBrowser()
        }
        val view = binding.root
        viewModel.authorizationProperty.observe(this, Observer {
            if (it != null){
                startMainActivity(it.access_token)
            }
        })

        setContentView(view)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val code: String? = intent!!.data!!.getQueryParameter("code")
        viewModel.getTwicasAuthorizationProperty(code!!)




    }

    private fun openBrowser(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(AuthorizationURL))
        startActivity(intent)
    }

    private fun startMainActivity(accessToken: String){
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("ACCESS_TOKEN", accessToken)
        }
        startActivity(intent)
    }
}