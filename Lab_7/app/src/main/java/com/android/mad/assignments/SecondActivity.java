package com.android.mad.assignments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // устанавливаем значения ключей
    public static final String TRANSMITTED_STRING = "transmittedString";
    public static final String TRANSMITTED_INT = "transmittedInt";
    public static final String TRANSMITTED_BOOLEAN = "transmittedBoolean";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        // получаем переданные данные из главной активности
        String transmittedString = getIntent().getStringExtra(TRANSMITTED_STRING);
        int transmittedInt = getIntent().getIntExtra(TRANSMITTED_INT, -1);
        boolean transmittedBoolean = getIntent().getBooleanExtra(TRANSMITTED_BOOLEAN, false);

        // назожим нужное TextView и передаём туда переданные значения
        TextView textView = findViewById(R.id.second_activity_text_view);
        textView.setText("These values were passed from previos screen"
                + ": transmittedString: " + transmittedString
                + ": transmittedInt: " + transmittedInt
                + ": transmittedBoolean: " + transmittedBoolean);

        /*
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
             Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
             return insets;
         });
        */
    }
}