package com.student.student_order

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button


class HomePageActivity : AppCompatActivity() {
    lateinit var  mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        mButton =findViewById(R.id.button)
        mButton.setOnClickListener {
            startActivity(Intent(this,OrderActivity::class.java))

        }

    }

}
