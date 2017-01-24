package com.spoon.DeliciousCanteen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 2015/7/24.
 */
public class StudentAccountChoiceActivity extends Activity {
    private RadioGroup rg;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentaccountchoice);
        rg= (RadioGroup) findViewById(R.id.radioGroup);
        findViewById(R.id.makesure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int id= rg.getCheckedRadioButtonId();
                if(id==R.id.sellSurface) {
                    Intent intent=new Intent(StudentAccountChoiceActivity.this,ShoppingActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}