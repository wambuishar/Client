package com.example.sha.client;
import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);


        Button btn_addusers = findViewById(R.id.btn_addusers);

        Button btn_view = findViewById(R.id.btn_view);

        Button btn_report = findViewById(R.id.btn_reports);

        Button btn_alert = findViewById(R.id.btn_alert);

        /**
         * Handling all button click events
         * */

        // Listening to News Feed button click
        btn_addusers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), User.class);
                startActivity(i);
            }
        });

        // Listening Friends button click
        btn_view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Alert.class);
                startActivity(i);
            }
        });

        // Listening Messages button click
        btn_report.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Report.class);
                startActivity(i);
            }
        });

        // Listening to Places button click
        btn_alert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
                Intent i = new Intent(getApplicationContext(), Notification.class);
                startActivity(i);
            }
        });


    }
}
