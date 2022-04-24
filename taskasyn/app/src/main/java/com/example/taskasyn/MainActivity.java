package com.example.taskasyn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Progress;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Progress = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                CountingTask task = new CountingTask();
                task.execute(0);
            }
        });

    }

    public class CountingTask extends AsyncTask<Integer, Integer, Integer> {
        CountingTask() {
        }

        @Override
        protected Integer doInBackground(Integer... params) {
            int i = params[0];
            while (i < 100) {
                SystemClock.sleep(250);
                i++;
                if (i % 5 == 0) {
                    publishProgress(i);
                }
            }
            return i;
        }

        protected void onProgressUpdate(Integer... progress) {
            Progress.setText("Progress : " + progress[0] + "%");
        }

        protected void onPostExecute(Integer result) {
            Progress.setText("Completed : " + result + "%");
        }

        protected void onPreExecute() {
            Progress.setText("Start");
        }
    }
}