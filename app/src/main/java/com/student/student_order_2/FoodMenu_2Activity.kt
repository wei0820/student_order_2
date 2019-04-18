package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CheckableImageButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button

import kotlinx.android.synthetic.main.activity_food_menu_2.*

class FoodMenu_2Activity : AppCompatActivity() {
    lateinit var mButton: Button
    lateinit var mButto2:Button
    lateinit var mOrder :Button
    lateinit var mOrderList:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_menu_2)
        mButton = findViewById(R.id.button)
        mButto2 = findViewById(R.id.button2)
        mOrder = findViewById(R.id.order)
        mOrder.setOnClickListener {
            finish()
        }
        mOrderList = findViewById(R.id.orderlist)
        mOrderList.setOnClickListener {
            startActivity(Intent(this,OrderListActivity::class.java))
        }
        mButton.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putInt("key",4)
            intent.putExtras(bundle)
            intent.setClass(this,addFoodActivity::class.java)
            startActivity(intent)
        }
        mButto2.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putInt("key",5)
            intent.putExtras(bundle)
            intent.setClass(this,addFoodActivity::class.java)
            startActivity(intent)
        }

    }

}
