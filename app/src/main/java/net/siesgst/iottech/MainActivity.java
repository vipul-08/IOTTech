package net.siesgst.iottech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Button bt1;
    TextView lgn;
    Button bt2;
    String login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lgn = (TextView) findViewById(R.id.lgn);
        sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        login = sharedPreferences.getString("login","0");
        if("0".equals(login)) {
            lgn.setText("Login");
            lgn.setClickable(true);
        }
        else if("1".equals(login)) {
            String name = sharedPreferences.getString("Name","");
            lgn.setText(name);
            lgn.setClickable(false);
        }

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("0".equals(login)) {
                    startActivity(new Intent(MainActivity.this,Login.class));
                }
            }
        });

        bt1 = (Button) findViewById(R.id.eyantra);
        bt2 = (Button) findViewById(R.id.markattendence);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,EyantraStatus.class));
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("1".equals(sharedPreferences.getString("login","")))
                    startActivity(new Intent(MainActivity.this,MarkAttendence.class));
            }
        });
    }
}