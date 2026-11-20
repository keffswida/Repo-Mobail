package com.example.inimobail.switchRatingBar;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.inimobail.R;

public class SwitchRatingBarActivity extends AppCompatActivity {

    Switch ini_switch;
    RatingBar ini_ratingbar;
    TextView text_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_switch_rating_bar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ini_switch = findViewById(R.id.ini_switch);
        ini_ratingbar = findViewById(R.id.ini_ratingbar);
        text_rating = findViewById(R.id.text_rating);

        ini_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                // tadi di isIndicator = true artinya rating bar di lock
                // sekarang di false biar bisa di cek, selama wifi = checked
                ini_ratingbar.setIsIndicator(!isChecked);


                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "wifine nyala cak", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "wifine mati cak", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ini_ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int int_rating = (int) rating;
                String rating_desc;

                if (ini_switch.isChecked()) {

                }

                switch (int_rating) {
                    case 1:
                        rating_desc = "guak en ae cak";
                        break;
                    case 2:
                        rating_desc = "pls sng niat cak";
                        break;
                    case 3:
                        rating_desc = "yo";
                        break;
                    case 4:
                        rating_desc = "mayan lah";
                        break;
                    case 5:
                        rating_desc = "sip sipp";
                        break;
                    default:
                        rating_desc = "sng temen ae cak";
                        break;
                }

                if (fromUser) {
                    // Toast.makeText(getApplicationContext(), "Rating: " + rating + " stars", Toast.LENGTH_SHORT).show();
                    text_rating.setText(rating_desc + " (" + int_rating + "/5)");
                }
            }
        });
    }
}