package com.spoon.DeliciousCanteen.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.spoon.DeliciousCanteen.ShoppingActivity;
import com.spoon.DeliciousCanteen.R;

/**
 * Created by Administrator on 2015/7/17.
 */
public class StartActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(StartActivity.this,ShoppingActivity.class);
                startActivity(intent);
                finish();
            }
        },200);
    }
}