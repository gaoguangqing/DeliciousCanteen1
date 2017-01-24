package com.spoon.DeliciousCanteen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/7/18.
 */
public class ScoreActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        findViewById(R.id.buttonScoreBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();

        String s=intent.getStringExtra("ta");
                ((TextView) (findViewById(R.id.textViewFName))).setText(s);
    }
}