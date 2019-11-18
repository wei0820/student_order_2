package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import com.facebook.CallbackManager
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.widget.LoginButton
import com.student.student_order_2.R


class HomePageActivity : AppCompatActivity() {
    lateinit var  mButton: Button
    lateinit var mFbLoginBtn : LoginButton
    var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callbackManager = CallbackManager.Factory.create()
        AppEventsLogger.activateApp(this)
        FacebookSdk.sdkInitialize(applicationContext)
        setContentView(R.layout.activity_home_page)
        mButton =findViewById(R.id.button)
        mFbLoginBtn = findViewById(R.id.login_button)
        FacebookManager.printHashKey(this)
        FacebookManager.fbLogin(this,mFbLoginBtn,callbackManager,OrderActivity::class.java)
//        mButton.setOnClickListener {
//            startActivity(Intent(this, OrderActivity::class.java))
//
//        }
    }

}
