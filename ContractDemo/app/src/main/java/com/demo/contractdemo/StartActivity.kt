package com.demo.contractdemo

import android.content.Intent
import android.view.View
import android.widget.EditText
import com.sass.contract.SassLibSDK
import com.sass.contract.SassMainActivity
import com.sass.contract.base.BaseActivity
import com.sass.contract.common.baseui.toast.MToast

class StartActivity : BaseActivity() {
    val editText: EditText? by lazy {
        findViewById(R.id.et)
    }
    override fun getContentViewId(): Int {
        return R.layout.activity_start
    }

    override fun injectDagger() {
    }

    override fun initViewsAndEvents() {

        findViewById<View>(R.id.btnGo)?.setOnClickListener {
            val token = editText?.text?.toString()?.trim()
            if (token.isNullOrEmpty()) {
                MToast.fail(this@StartActivity, "token 不能为空")
                return@setOnClickListener
            }
            SassLibSDK.login(token)
            startActivity(Intent(this@StartActivity, SassMainActivity::class.java))
        }

        if (SassLibSDK.isLogin()) startActivity(Intent(this@StartActivity, SassMainActivity::class.java))
    }
}