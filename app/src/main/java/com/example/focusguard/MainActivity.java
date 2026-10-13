package com.example.focusguard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btNewSession;
    private Button btAi;
    private Button btStatistics;
    private Button btSend;

    private static final int REQUEST_SUBJECT = 1;
    private static final int REQUEST_AI = 2;
    private static final int REQUEST_STATISTICS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btNewSession = findViewById(R.id.bt_new_session);
        btAi = findViewById(R.id.bt_ai);
        btStatistics = findViewById(R.id.bt_statistics);
        btSend = findViewById(R.id.bt_send);

        btNewSession.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    SubjectActivity.class
            );

            startActivityForResult(intent, REQUEST_SUBJECT);
        });

        btAi.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    AIAssistantActivity.class
            );

            startActivityForResult(intent, REQUEST_AI);
        });

        btStatistics.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    StatisticsActivity.class
            );

            startActivityForResult(intent, REQUEST_STATISTICS);
        });

        btSend.setOnClickListener(v -> {
            Intent intent = new Intent();

            intent.setClassName(
                    "com.example.app2",
                    "com.example.app2.MainActivity"
            );

            intent.putExtra(
                    "message",
                    "Bonjour depuis FocusGuard AI !"
            );

            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data
    ) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == REQUEST_SUBJECT) {
                Toast.makeText(
                        MainActivity.this,
                        "Résultat reçu de SubjectActivity",
                        Toast.LENGTH_SHORT
                ).show();

            } else if (requestCode == REQUEST_AI) {
                Toast.makeText(
                        MainActivity.this,
                        "Résultat reçu de AIAssistantActivity",
                        Toast.LENGTH_SHORT
                ).show();

            } else if (requestCode == REQUEST_STATISTICS) {
                Toast.makeText(
                        MainActivity.this,
                        "Résultat reçu de StatisticsActivity",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}
