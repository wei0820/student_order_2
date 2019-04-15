package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.student.student_order_2.R

class OrderActivity : AppCompatActivity() {
    lateinit var mSettingButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        mSettingButton = findViewById(R.id.settingbtn)
        mSettingButton.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))

        }

    }

}
