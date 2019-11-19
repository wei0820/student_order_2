package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class OrderActivity : AppCompatActivity() {
    lateinit var mSettingButton: Button
    lateinit var mFood1:Button
    lateinit var mFoo2 :Button
    lateinit var morderLitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        mSettingButton = findViewById(R.id.settingbtn)
        morderLitButton = findViewById(R.id.orderbtn)
        mSettingButton.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))

        }
        morderLitButton.setOnClickListener {
            if(!FacebookManager.checkFbState(this))
            {
                Toast.makeText(this,"請先登入",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            startActivity(Intent(this,OrderListActivity::class.java))
        }
        mFood1 = findViewById(R.id.food1)
        mFoo2 = findViewById(R.id.food2)

        mFood1.setOnClickListener {
            if(!FacebookManager.checkFbState(this))
            {
                Toast.makeText(this,"請先登入",Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            startActivity(Intent(this, FoodMenu_1Activity::class.java))

        }
        mFoo2.setOnClickListener {
            if(!FacebookManager.checkFbState(this))
            {
                Toast.makeText(this,"請先登入",Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            startActivity(Intent(this, FoodMenu_2Activity::class.java))

        }


    }

}
