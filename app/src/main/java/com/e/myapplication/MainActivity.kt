package com.e.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.e.myapplication.services.NetworkConnection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)s
        setContentView(R.layout.activity_main)

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer{isConnected ->
            if (isConnected){
                layoutDisconnect.visibility = View.GONE
                layoutConnected.visibility = View.VISIBLE
            }else{
                layoutConnected.visibility = View.GONE
                layoutDisconnect.visibility = View.VISIBLE
            }
        })
    }
}
