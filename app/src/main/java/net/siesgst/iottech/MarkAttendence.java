package net.siesgst.iottech;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MarkAttendence extends AppCompatActivity {
    EditText reason;
    Button sbmitReason;
    DatabaseReference reference;
    SharedPreferences sharedPreferences;
    int rn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendence);
        sbmitReason = (Button) findViewById(R.id.sbmitReason);
        reason = (EditText) findViewById(R.id.reason);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference("/siesgst");
        sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        rn = Integer.valueOf(sharedPreferences.getString("Roll Number",""));
        sbmitReason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rsn = reason.getText().toString();
                reference.child("/student/"+rn+"/reason").setValue(rsn);
                reason.setText(null);
            }
        });
    }
}