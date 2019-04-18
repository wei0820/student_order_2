package com.student.student_order_2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.*

import kotlinx.android.synthetic.main.activity_order_list.*

class OrderListActivity : AppCompatActivity() {
    lateinit var mListView: ListView
    var arrayList = ArrayList<String>()
    lateinit var mPrice : TextView
    lateinit var mClearButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)
        mListView = findViewById(R.id.listview)
        mPrice = findViewById(R.id.price)
        mPrice.text = "總價："+ MySharedPrefernces.getMusicState(this)
        mClearButton = findViewById(R.id.clear)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, MySharedPrefernce.getList(this))
        mListView.adapter = adapter
        mClearButton.setOnClickListener {
            arrayList.clear()
            MySharedPrefernces.saveMusicState(this,0)
            MySharedPrefernce.setList(this,arrayList)
            Toast.makeText(this,"全部清除",Toast.LENGTH_SHORT).show()
            mPrice.text = "0"

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, MySharedPrefernce.getList(this))
            mListView.adapter = adapter
        }

    }

}
