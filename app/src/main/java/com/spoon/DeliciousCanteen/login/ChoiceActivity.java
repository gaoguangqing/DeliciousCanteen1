package com.spoon.DeliciousCanteen.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.spoon.DeliciousCanteen.R;

/**
 * Created by Administrator on 2015/7/21.
 */
public class ChoiceActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);
        /**
         * 学生登录按钮响应
         */
        findViewById(R.id.buttonStudentIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChoiceActivity.this,UserLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.buttonAdmIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChoiceActivity.this,AdmLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}