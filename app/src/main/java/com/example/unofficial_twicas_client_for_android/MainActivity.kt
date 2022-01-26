package com.example.unofficial_twicas_client_for_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import com.example.unofficial_twicas_client_for_android.R.id.navigation
import com.example.unofficial_twicas_client_for_android.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val accessToken: String? = intent.getStringExtra("ACCESS_TOKEN")

        val bundle = Bundle()
        bundle.putString("accessToken", accessToken!!)


        setContentView(R.layout.activity_main)

        // setContentViewより前だと落ちる何故かアプリが落ちる　Passing argument data to the startDestination
        findNavController(R.id.nav_host_fragment).setGraph(R.navigation.navigation, bundle)


    }
}