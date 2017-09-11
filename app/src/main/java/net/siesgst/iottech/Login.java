package net.siesgst.iottech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText name,rollnumber,pwd;
    Button btn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText) findViewById(R.id.nm);
        rollnumber = (EditText) findViewById(R.id.rn);
        pwd = (EditText) findViewById(R.id.pwd);
        btn = (Button) findViewById(R.id.sbmtLogin);
        sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("Name",name.getText().toString());
                editor.putString("Roll Number",rollnumber.getText().toString());
                editor.putString("Password",pwd.getText().toString());
                editor.putString("login","1");
                editor.apply();
                startActivity(new Intent(Login.this,MainActivity.class));
            }
        });


    }
}
