package net.siesgst.iottech;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EyantraStatus extends AppCompatActivity {

    private DatabaseReference reference;
    private TextView listOfStudents;
    private Button btn;
    private String sName,str1;
    private EditText msg;
    private String tempVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eyantra_status);
        listOfStudents = (TextView) findViewById(R.id.students);
        //NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        btn = (Button) findViewById(R.id.btn);
        msg = (EditText) findViewById(R.id.yourMsg);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference("/siesgst");
        reference.child("/attendance/1/status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if(value.equals("1")) {
                    reference.child("/student/1/name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String val = dataSnapshot.getValue(String.class);
                            sName = "\n"+val;
                            listOfStudents.setText(listOfStudents.getText().toString()+sName);
                            //viewNotification("New Entry",val+" entered");
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(value.equals("0")) {
                    str1 = listOfStudents.getText().toString();
                    reference.child("/student/1/name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            tempVal = dataSnapshot.getValue(String.class);
                            str1 = str1.replaceAll("\n"+tempVal,"");
                            listOfStudents.setText(str1);
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        reference.child("/attendance/2/status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if(value.equals("1")) {
                    reference.child("/student/2/name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String val = dataSnapshot.getValue(String.class);
                            sName = "\n"+val;
                            listOfStudents.setText(listOfStudents.getText().toString()+sName);
                            //viewNotification("New Entry",val+" entered");
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(value.equals("0")) {
                    str1 = listOfStudents.getText().toString();
                    reference.child("/student/2/name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            tempVal = dataSnapshot.getValue(String.class);
                            str1 = str1.replaceAll("\n"+tempVal,"");
                            listOfStudents.setText(str1);
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        reference.child("/attendance/3/status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if(value.equals("1")) {
                    reference.child("/student/3/name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String val = dataSnapshot.getValue(String.class);
                            sName = "\n"+val;
                            listOfStudents.setText(listOfStudents.getText().toString()+sName);
                            //viewNotification("New Entry",val+" entered");
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(value.equals("0")) {
                    str1 = listOfStudents.getText().toString();
                    reference.child("/student/3/name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            tempVal = dataSnapshot.getValue(String.class);
                            str1 = str1.replaceAll("\n"+tempVal,"");

                            listOfStudents.setText(str1);
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        reference.child("/attendance/4/status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if(value.equals("1")) {
                    reference.child("/student/4/name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String val = dataSnapshot.getValue(String.class);
                            sName = "\n"+val;
                            listOfStudents.setText(listOfStudents.getText().toString()+sName);
                            //viewNotification("New Entry",val+" entered");
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else if(value.equals("0")) {
                    str1 = listOfStudents.getText().toString();
                    reference.child("/student/4/name").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            tempVal = dataSnapshot.getValue(String.class);
                            Log.d("text: ",tempVal);
                            str1 = str1.replaceAll("\n"+tempVal,"");

                            listOfStudents.setText(str1);

                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = msg.getText().toString();
                reference.child("/message/value").setValue(message);
                msg.setText(null);
            }
        });
    }

    public void viewNotification(String title,String text)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this) ;
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(title);
        builder.setContentText(text);
        Intent intent=new Intent(this,MainActivity.class);
        TaskStackBuilder stackBuilder= TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent= stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());
    }
}
