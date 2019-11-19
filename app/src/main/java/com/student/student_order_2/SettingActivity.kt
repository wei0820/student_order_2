package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.google.firebase.FirebaseApp


class SettingActivity : AppCompatActivity() {
    lateinit var mButton:Button
    lateinit var mButton2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        FirebaseApp.initializeApp(this)


        mButton = findViewById(R.id.button)
        mButton2 = findViewById(R.id.button2)
        mButton.setOnClickListener {
            MyApi.setAlertDilog(this,"關於我們","嶺東科技大學資訊網路系\n\n粘竣凱\n陳盈臻 李俊逸 張祐源 林信局")

        }
        mButton2.setOnClickListener {
            startActivity(Intent(this,ShopNewsActivity::class.java))

        }

    }


}
