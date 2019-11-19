package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class FoodMenu_1Activity : AppCompatActivity() {
    lateinit var mButton1:Button
    lateinit var mButton2:Button
    lateinit var mButton3:Button
    lateinit var mButton4: Button
    lateinit var mOrderbtn :Button
    lateinit var morder :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_menu_1)
        mButton1 = findViewById(R.id.button)
        mButton2 = findViewById(R.id.button2)
        mButton3 = findViewById(R.id.button3)
        mButton4 = findViewById(R.id.button4)
        mOrderbtn = findViewById(R.id.orderbtn)
        morder = findViewById(R.id.order)
        morder.setOnClickListener {
            finish()
        }
        mOrderbtn.setOnClickListener {
            startActivity(Intent(this,OrderListActivity::class.java))
        }
        mButton1.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putInt("key",0)
            intent.putExtras(bundle)
            intent.setClass(this,addFoodActivity::class.java)
            startActivity(intent)
        }
        mButton2.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putInt("key",1)
            intent.putExtras(bundle)
            intent.setClass(this,addFoodActivity::class.java)
            startActivity(intent)
        }
        mButton3.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putInt("key",2)
            intent.putExtras(bundle)
            intent.setClass(this,addFoodActivity::class.java)
            startActivity(intent)
        }
        mButton4.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putInt("key",3)
            intent.putExtras(bundle)
            intent.setClass(this,addFoodActivity::class.java)
            startActivity(intent)
        }
    }

}
