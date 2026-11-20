package com.example.inimobail.checker;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inimobail.R;

public class CheckerActivity extends AppCompatActivity {

    // declare variable
    Button btn_cek;
    TextView label_form,label_hasil,view_hasil;
    EditText form_bil;

    // declare logic file
    Checker checker = new Checker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checker);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_cek = findViewById(R.id.btn_cek);
        label_form = findViewById(R.id.label_form);
        label_hasil = findViewById(R.id.label_hasil);
        view_hasil = findViewById(R.id.view_hasil);
        form_bil = findViewById(R.id.form_bil);

        btn_cek.setOnClickListener(v -> {
            // get label_form value
            String userInput = form_bil.getText().toString();
            // change string -> int
            int num = Integer.parseInt(userInput);

            checker.setI(num);
            checker.checkNum();

            if (checker.getBool()) {
                view_hasil.setText(checker.getI() + " iku Genap.");
                Toast.makeText(this, "iki genap hoo", Toast.LENGTH_SHORT).show();
                Log.d("Hasil", "kon gey-nap");
            } else {
                view_hasil.setText(checker.getI() + " iku Ganjil.");
                Toast.makeText(this, "iki ganjil hoo", Toast.LENGTH_SHORT).show();
                Log.d("Hasil", "kon gey-njil");
            }
        });
    }
}