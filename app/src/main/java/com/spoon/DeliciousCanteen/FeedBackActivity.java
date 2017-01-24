package com.spoon.DeliciousCanteen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2015/7/21.
 */
public class FeedBackActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        findViewById(R.id.buttonFedSure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FeedBackActivity.this,FeedBackSucceed.class);
                startActivity(intent);
                finish();
            }
        });
        findViewById(R.id.buttonFedReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}