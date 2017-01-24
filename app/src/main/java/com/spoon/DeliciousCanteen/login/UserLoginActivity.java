package com.spoon.DeliciousCanteen.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.spoon.DeliciousCanteen.R;
import com.spoon.DeliciousCanteen.StudentAccountChoiceActivity;

/**
 * Created by Administrator on 2015/7/19.
 */
public class UserLoginActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlogin);
        /**
         * ³·Ïú
         */
        findViewById(R.id.btCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.btSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText) findViewById(R.id.editText);
                EditText editText2= (EditText) findViewById(R.id.editText2);
                String name=editText.getText().toString();
                String password=editText2.getText().toString();
                if("admin".equals(name)&&"123".equals(password))
                {
                    Intent intent=new Intent(UserLoginActivity.this, StudentAccountChoiceActivity.class);
                    startActivity(intent);
                    finish();

                }
                else {
                    Toast toast=Toast.makeText(UserLoginActivity.this,"name or password is wrong",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}