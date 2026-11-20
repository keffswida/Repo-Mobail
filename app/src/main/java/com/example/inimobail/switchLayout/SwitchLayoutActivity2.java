package com.example.inimobail.switchLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inimobail.R;

public class SwitchLayoutActivity2 extends AppCompatActivity {

    Button ini_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_switch_layout2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boolean status = getIntent().getBooleanExtra("status", false);
        if (status)
            Toast.makeText(SwitchLayoutActivity2.this, "woi mpruy\uD83D\uDE39", Toast.LENGTH_SHORT).show();

        ini_button = findViewById(R.id.btn_pindah);

        ini_button.setOnClickListener(v -> {
            Intent ini_intent = new Intent(this, SwitchLayoutActivity.class);
            startActivity(ini_intent);
            finish(); // mengakhiri activity saat ini, agar tidak bisa di back
        });
    }
}