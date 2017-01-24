package com.spoon.DeliciousCanteen.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.spoon.DeliciousCanteen.R;

/**
 * Created by Administrator on 2015/7/21.
 */
public class AdmLoginActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admlogin);
        findViewById(R.id.btCancel2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.btSubmit2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText) findViewById(R.id.AdmName);
                EditText editText2= (EditText) findViewById(R.id.AdmPassworld);
                String name=editText.getText().toString();
                String password=editText2.getText().toString();
                if("admin".equals(name)&&"123".equals(password))
                {

                    finish();

                }
                else {
                    Toast toast=Toast.makeText(AdmLoginActivity.this,"name or password is wrong",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}