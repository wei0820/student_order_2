package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.student.student_order_2.R

class OrderActivity : AppCompatActivity() {
    lateinit var mSettingButton: Button
    lateinit var mFood1:Button
    lateinit var mFoo2 :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        mSettingButton = findViewById(R.id.settingbtn)
        mSettingButton.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))

        }
        mFood1 = findViewById(R.id.food1)
        mFoo2 = findViewById(R.id.food2)

        mFood1.setOnClickListener {
            startActivity(Intent(this, FoodMenu_1Activity::class.java))

        }
        mFoo2.setOnClickListener {
            startActivity(Intent(this, FoodMenu_2Activity::class.java))

        }


    }

}
