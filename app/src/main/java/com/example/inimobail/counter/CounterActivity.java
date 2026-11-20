package com.example.inimobail.counter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inimobail.R;

public class CounterActivity extends AppCompatActivity {

    // declare variable
    Button plus_btn, min_btn, reset_btn;
    TextView tv;

    // declare backend
    Counter counter = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        plus_btn = findViewById(R.id.plus_btn);
        min_btn = findViewById(R.id.min_btn);
        reset_btn = findViewById(R.id.reset_btn);
        tv = findViewById(R.id.view_nomor);

        plus_btn.setOnClickListener(v -> {
            counter.plus();
            tv.setText(String.valueOf(counter.getI()));
        });

        min_btn.setOnClickListener(v -> {
            counter.min();
            tv.setText(String.valueOf(counter.getI()));
        });

        reset_btn.setOnClickListener(v -> {
            counter.reset();
            tv.setText(String.valueOf(counter.getI()));
        });
    }
}