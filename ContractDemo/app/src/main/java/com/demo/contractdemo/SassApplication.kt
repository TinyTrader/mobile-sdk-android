package com.demo.contractdemo

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.sass.contract.SassLibSDK

class SassApplication : Application() {
    companion object {
        val host = "chimchim.top"
        val key = "xxOi"
        val jwtToken = ""

    }

    override fun onCreate() {
        super.onCreate()
        SassLibSDK.init(
            this,
            key,
            host,
            jwtToken,
            BuildConfig.DEBUG,
            object : SassLibSDK.SassLibSdkCallBack {
                override fun goLogin(context: Context) {
                    Toast.makeText(context,"login go", Toast.LENGTH_SHORT).show()
                }

                override fun transfer(context: Context) {
                    Toast.makeText(context,"transfer go", Toast.LENGTH_SHORT).show()

                }
            })
    }
}