package com.student.student_order_2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.widget.*
import com.jackpan.libs.mfirebaselib.MfiebaselibsClass
import com.jackpan.libs.mfirebaselib.MfirebaeCallback


import kotlinx.android.synthetic.main.activity_order_list.*

class OrderListActivity : AppCompatActivity(), MfirebaeCallback {
    override fun getUserLogoutState(p0: Boolean) {
    }

    override fun resetPassWordState(p0: Boolean) {
    }

    override fun getsSndPasswordResetEmailState(p0: Boolean) {
    }

    override fun getFirebaseStorageType(p0: String?, p1: String?) {
    }

    override fun getUpdateUserName(p0: Boolean) {
    }

    override fun getDatabaseData(p0: Any?) {
    }

    override fun getuserLoginEmail(p0: String?) {
    }

    override fun getDeleteState(p0: Boolean, p1: String?, p2: Any?) {
    }

    override fun getFireBaseDBState(p0: Boolean, p1: String?) {
    }

    override fun getuseLoginId(p0: String?) {
    }

    override fun createUserState(p0: Boolean) {
    }

    override fun useLognState(p0: Boolean) {
    }

    override fun getFirebaseStorageState(p0: Boolean) {
    }

    lateinit var mListView: ListView
    var arrayList = ArrayList<String>()
    lateinit var mPrice: TextView
    lateinit var mClearButton: Button
    private var mfiebaselibsClass: MfiebaselibsClass? = null
    lateinit var mbtn1: Button
    lateinit var mbtn2: Button
    lateinit var mbtn3: Button
    var name = "內用"

    var list = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mfiebaselibsClass = MfiebaselibsClass(this, this)

        setContentView(R.layout.activity_order_list)
        mListView = findViewById(R.id.listview)
        mPrice = findViewById(R.id.price)
        mbtn1 = findViewById(R.id.btn11)
        mbtn2 = findViewById(R.id.btn22)
        mbtn3 = findViewById(R.id.send)
        mPrice.text = "總價：" + MySharedPrefernces.getMusicState(this)
        mClearButton = findViewById(R.id.clear)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, MySharedPrefernce.getList(this))
        mListView.adapter = adapter
        mClearButton.setOnClickListener {
            arrayList.clear()
            MySharedPrefernces.saveMusicState(this, 0)
            MySharedPrefernce.setList(this, arrayList)
            Toast.makeText(this, "全部清除", Toast.LENGTH_SHORT).show()
            mPrice.text = "0"

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, MySharedPrefernce.getList(this))
            mListView.adapter = adapter
        }
        mbtn1.setOnClickListener {
            name = "內用"
            Toast.makeText(this, "選擇內用", Toast.LENGTH_SHORT).show()


        }
        mbtn2.setOnClickListener {
            Toast.makeText(this, "選擇外帶", Toast.LENGTH_SHORT).show()

            name = "外帶"

        }
        mbtn3.setOnClickListener {
            if (MySharedPrefernce.getList(this).size != 0) {
                MySharedPrefernce.getList(this).forEach {
                    list = list + "," + it

                }

                setMemberData(list, name, MySharedPrefernces.getMusicState(this).toString())
                Toast.makeText(this, "已送出訂單!", Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun setMemberData(
        list: String, name: String,
        price: String
    ) {
        val memberMap = HashMap<String, String>()
        memberMap.put("id", MySharedPrefernces.getUserPic(this))
        memberMap.put("清單", list)
        memberMap.put("方式", name)
        memberMap.put("總價", price)
//        memberMap.put(MemberData.KEY_MEMBERLV, MemberData.MEMBER_LV_1)
        mfiebaselibsClass!!.setFireBaseDB(
            "https://order-c72e7.firebaseio.com/foodlist",
            MySharedPrefernces.getUserPic(this),
            memberMap
        )


    }
}
