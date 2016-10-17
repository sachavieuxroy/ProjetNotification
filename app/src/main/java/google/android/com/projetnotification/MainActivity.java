package google.android.com.projetnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static int NOTIFICATION_ID = 0;
    private final static int REQUEST_CODE = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addNotification = (Button) findViewById(R.id.addNotification);
        addNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
    }

    protected void createNotification() {
        final NotificationManager mNotification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        final Intent launchNotifiactionIntent = new Intent(this, MainActivity.class);

        final PendingIntent pendingIntent = PendingIntent.getActivity(this,
                REQUEST_CODE, launchNotifiactionIntent,
                PendingIntent.FLAG_ONE_SHOT);

        Notification.Builder builder = new Notification.Builder(this)
                .setWhen(System.currentTimeMillis())
                .setTicker(
                        getResources().getString(
                                R.string.notification_launching_title))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(
                        getResources().getString(R.string.notification_title))
                .setContentText(
                        getResources().getString(R.string.notification_desc))
                .setContentIntent(pendingIntent);

        mNotification.notify(NOTIFICATION_ID, builder.getNotification());
    }

}
