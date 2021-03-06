package com.student.student_order_2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.jackpan.libs.mfirebaselib.MfiebaselibsClass;
import com.jackpan.libs.mfirebaselib.MfirebaeCallback;

import java.util.ArrayList;

public class FoodLoveListActivity extends AppCompatActivity implements MfirebaeCallback {
    ListView mListview;
    MfiebaselibsClass mfiebaselibsClass;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayList2 = new ArrayList<>();
    private ProgressDialog progress;


    ListAdapter adapter;
    private static final String TAG = "FoodLoveListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mfiebaselibsClass = new MfiebaselibsClass(this,this);
        setContentView(R.layout.activity_food_love_list);
        progress = new ProgressDialog(this);
        progress.setMessage("讀取中");
        //progress.setIndeterminate(true);
        progress.show();
        mListview = findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 ,arrayList);
        setFireBase();
    }

    @Override
    public void getDatabaseData(Object o) {



    }

    @Override
    public void getDeleteState(boolean b, String s, Object o) {

    }

    @Override
    public void createUserState(boolean b) {

    }

    @Override
    public void useLognState(boolean b) {

    }

    @Override
    public void getuseLoginId(String s) {

    }

    @Override
    public void getuserLoginEmail(String s) {

    }

    @Override
    public void resetPassWordState(boolean b) {

    }

    @Override
    public void getFireBaseDBState(boolean b, String s) {

    }

    @Override
    public void getFirebaseStorageState(boolean b) {

    }

    @Override
    public void getFirebaseStorageType(String s, String s1) {

    }

    @Override
    public void getsSndPasswordResetEmailState(boolean b) {

    }

    @Override
    public void getUpdateUserName(boolean b) {

    }

    @Override
    public void getUserLogoutState(boolean b) {

    }

    private void setFireBase() {
        Firebase.setAndroidContext(this);
        String url = "https://order-c72e7.firebaseio.com/foodlist/";

        Firebase mFirebaseRef = new Firebase(url);
        mFirebaseRef.child(MySharedPrefernces.getUserPic(this)).addChildEventListener(new com.firebase.client.ChildEventListener() {
            @Override
            public void onChildAdded(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                Log.d(TAG, "onChildAdded: "+dataSnapshot.toString());
                FoodData foodData = dataSnapshot.getValue(FoodData.class);
                String st = "會員編號:"+foodData.id+"\n\n"+"點過的商品:"+foodData.list +"\n\n"+"點餐時間:"+foodData.date;
                arrayList.add(st);
                mListview.setAdapter(adapter);
                progress.dismiss();
            }

            @Override
            public void onChildChanged(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(com.firebase.client.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });


    }
}
