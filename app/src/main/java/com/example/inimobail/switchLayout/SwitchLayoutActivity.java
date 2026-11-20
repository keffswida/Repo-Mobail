package com.example.inimobail.switchLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inimobail.R;

public class SwitchLayoutActivity extends AppCompatActivity {

    Button ini_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_switch_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ini_button = findViewById(R.id.btn_pindah);

        ini_button.setOnClickListener(v -> {
            Intent ini_intent = new Intent(this, SwitchLayoutActivity2.class);
            ini_intent.putExtra("status", true);
            startActivity(ini_intent);
            finish(); // mengakhiri activity saat ini, agar tidak bisa di back
        });
    }
}