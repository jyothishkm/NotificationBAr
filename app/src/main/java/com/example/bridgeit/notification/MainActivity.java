package com.example.bridgeit.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button mNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    mNotification = (Button)findViewById(R.id.button_notify);
        mNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                Intent intent = new Intent(MainActivity.this,NotificationClass.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0,intent, 0 );
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Gmail");
                builder.setContentText("Forward Resume");
                builder.setTicker("From Mahi");
                builder.setSmallIcon(R.drawable.gmail);
                builder.setVibrate(new long[] {1000,1000,1000,1000,1000});
                Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(sound);
                builder.setContentIntent(pendingIntent);


                Notification notification = builder.build();
                notificationManager.notify(123, notification);

            }
        });
    }
}
