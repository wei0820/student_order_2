package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import com.facebook.CallbackManager
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.widget.LoginButton
import com.google.firebase.FirebaseApp


class SettingActivity : AppCompatActivity() {
    var callbackManager: CallbackManager? = null
    lateinit var mFbLoginBtn : LoginButton
    lateinit var mButton:Button
    lateinit var mButton2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callbackManager = CallbackManager.Factory.create()
        AppEventsLogger.activateApp(this)
        FacebookSdk.sdkInitialize(applicationContext)
        setContentView(R.layout.activity_setting)
        FirebaseApp.initializeApp(this)

        mFbLoginBtn = findViewById(R.id.login_button)
        FacebookManager.printHashKey(this)
        FacebookManager.fbLogin(this,mFbLoginBtn,callbackManager,SettingActivity::class.java)
        mButton = findViewById(R.id.button)
        mButton2 = findViewById(R.id.button2)
        mButton.setOnClickListener {
            MyApi.setAlertDilog(this,"關於我們","嶺東科技大學資訊網路系\n\n粘竣凱\n陳盈臻 李俊逸 張祐源 林信局")

        }
        mButton2.setOnClickListener {
            MyApi.setAlertDilog(this,"本店資訊","30年代的傳統口味的精緻料理，且是一種深具魅力的料理藝術，我們古法調配的湯頭加上純手工製作的手工麵線以及我們老闆自己親手滷的大腸和自己炒的辣蘿蔔，經過精心調配再現傳統美味" +
                    "\n地址:台中市神岡區中山路1313號")

        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager!!.onActivityResult(requestCode, resultCode, data)
    }

}
