package com.demo.contractdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sass.contract.SassLibSDK
import com.sass.contract.SassMainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start()
        findViewById<TextView>(R.id.tv)?.setOnClickListener {
            start()
        }
    }


    private fun start() {
//        SassLibSDK.login(SassApplication.jwtToken)
        startActivity(Intent(this, SassMainActivity::class.java))
    }

}