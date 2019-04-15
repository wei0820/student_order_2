package com.student.student_order_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.student.student_order_2.R;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton1,mbutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        mButton1 = findViewById(R.id.button);
        mbutton2 = findViewById(R.id.button2);
        mButton1.setOnClickListener(this);
        mbutton2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                startActivity(new Intent(this,FoodMenu_1Activity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this,FoodMenu_2Activity.class));

                break;
        }

    }
}
