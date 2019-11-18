package com.student.student_order_2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.activity_add_food.*

class addFoodActivity : AppCompatActivity() {
    lateinit var title :TextView
    lateinit var img : ImageView
    internal var array =
        intArrayOf( R.mipmap.photo4, R.mipmap.photo6,R.mipmap.photo3, R.mipmap.photo5,R.mipmap.photo1)
    internal var name = arrayOf("大腸麵線", "肉羹麵線", "綜合麵線", "清麵線", "香雞排", "花枝丸")
    internal var nameprice = arrayOf("小 45元", "大 60元",
        "小 45元", "大 60元",
        "小 45元", "大 60元"
        ,"小 35元", "大 50元",
        "55元","30元")

    lateinit var mNextBtn :Button
    lateinit var mOrderBtn :Button
    lateinit var mOrderList :Button
    var list = ArrayList<String>()
    lateinit var orderlist :String
    lateinit var mEditText: EditText
    lateinit var mbtn0 :Button
    lateinit var mbtn1 :Button
    lateinit var mbtn2 :Button

    lateinit var mbtn3 :Button
    var food = ""
    var fooname = ""
    lateinit var mSmallbtn :Button
    lateinit var mBig :Button
     var price:Int = 0
    var priceNum:Int = 0
    var priceNumTotal:Int = 0

    lateinit var mPrice :TextView

    var pricelist = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)
        title = findViewById(R.id.title)
        img = findViewById(R.id.img)
        mNextBtn = findViewById(R.id.nextbtn)
        mOrderBtn = findViewById(R.id.orderbtn)
        mOrderList = findViewById(R.id.orderlist)
        mEditText = findViewById(R.id.num)
        mbtn0 = findViewById(R.id.button0)
        mbtn1 = findViewById(R.id.button1)
        mbtn2 = findViewById(R.id.button2)
        mbtn3 = findViewById(R.id.button3)
        mSmallbtn = findViewById(R.id.small)
        mBig = findViewById(R.id.big)
        mPrice = findViewById(R.id.price)
        if (MySharedPrefernces.getMusicState(this)==0){
            priceNumTotal = 0
        }else{
            priceNumTotal = MySharedPrefernces.getMusicState(this)

        }
        mSmallbtn.setOnClickListener {
            Toast.makeText(this,"選擇小碗",Toast.LENGTH_SHORT).show()
            if (key==3){
               price = 35
            }else{
                price = 45

            }
//            priceNum = priceNum+(price * (mEditText.text.toString().toInt()))
//            MySharedPrefernces.saveMusicState(this,priceNum)

        }
        mBig.setOnClickListener {
            Toast.makeText(this,"選擇大碗",Toast.LENGTH_SHORT).show()
            if (key==3){
                price = 50
            }else{
                price = 60

            }


        }
        getDate()
        mNextBtn.setOnClickListener {
            if (!mEditText.text.isEmpty()){
                priceNum = priceNum+(price * (mEditText.text.toString().toInt()))
                priceNumTotal = priceNumTotal +priceNum
                MySharedPrefernces.saveMusicState(this,priceNumTotal)

                orderlist = fooname+mEditText.text+"個"+food+priceNum+"元"
                if(MySharedPrefernce.getList(this).size==0){
                    list.add(orderlist)


                }else{
                    list = MySharedPrefernce.getList(this)
                    list.add(orderlist)
                }
                MySharedPrefernce.setList(this,list)
                finish()

            }else{
                Toast.makeText(this,"請輸入數量",Toast.LENGTH_SHORT).show()
            }
        }
        mOrderBtn.setOnClickListener {

        }
        mOrderList.setOnClickListener {
            startActivity(Intent(this,OrderListActivity::class.java))
            finish()
        }
        mbtn0.setOnClickListener {
            food = "無辣"
            Toast.makeText(this, "選擇無辣", Toast.LENGTH_SHORT).show()
        }

        mbtn1.setOnClickListener {
            food = "小辣"
            Toast.makeText(this,"選擇小辣",Toast.LENGTH_SHORT).show()

        }
        mbtn2.setOnClickListener {
            food = "中辣"
            Toast.makeText(this,"選擇中辣",Toast.LENGTH_SHORT).show()


        }
        mbtn3.setOnClickListener {
            food = "大辣"
            Toast.makeText(this,"選擇大辣",Toast.LENGTH_SHORT).show()

        }
    }
     var key :Int = 0
    fun  getDate(){
       val i =  intent.extras.getInt("key",0)
        key = i
        when(i){
            0 ->{
                title.text = name[0]
                img.setImageResource(array[0])
                fooname = name[0]
                mPrice.text = nameprice[0]+"\n"+nameprice[1]
            }
            1 ->{
                title.text = name[1]
                img.setImageResource(array[1])
                fooname = name[1]
                mPrice.text = nameprice[0]+"\n"+nameprice[1]


            }
            2 ->{
                title.text = name[2]
                img.setImageResource(array[2])
                fooname = name[2]
                mPrice.text = nameprice[0]+"\n"+nameprice[1]

            }
            3 ->{
                fooname = name[3]

                title.text = name[3]
                img.setImageResource(array[0])
                mPrice.text = nameprice[6]+"\n"+nameprice[7]

            }
            4 ->{
                mSmallbtn.visibility = View.GONE
                mBig.visibility = View.GONE
                price = 55
                fooname = name[4]

                title.text = name[4]
                img.setImageResource(array[3])
                mPrice.text = nameprice[8]

            }
            5 ->{
                mSmallbtn.visibility = View.GONE
                mBig.visibility = View.GONE
                fooname = name[5]
                price = 30

                title.text = name[5]
                mPrice.text = nameprice[9]

                img.setImageResource(array[4])
            }

        }

    }
    fun  setview(int: Int){
        title.text = name[int]
        img.setImageResource(array[int])
    }

}
