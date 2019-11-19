package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.facebook.CallbackManager
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.widget.LoginButton


class HomePageActivity : AppCompatActivity() {
    lateinit var mFbLoginBtn : LoginButton
    var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callbackManager = CallbackManager.Factory.create()
        AppEventsLogger.activateApp(this)
        FacebookSdk.sdkInitialize(applicationContext)
        setContentView(R.layout.activity_home_page)
        mFbLoginBtn = findViewById(R.id.login_button)
        FacebookManager.printHashKey(this)
        FacebookManager.fbLogin(this,mFbLoginBtn,callbackManager,OrderActivity::class.java)

    }

    override fun onResume() {
        super.onResume()
        if (FacebookManager.checkFbState(this)){
            startActivity(Intent(this, OrderActivity::class.java))
            finish()

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager!!.onActivityResult(requestCode, resultCode, data)
    }

}
