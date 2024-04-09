package com.example.lab_6;

import android.os.Bundle;
import android.view.View;
import android.widget.*; // модуль содержит все графические элементы

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int num;
    boolean gameEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // связываем переменные с созданными элементами интерфейса
        tvInfo = (TextView) findViewById(R.id.textView); // метод возвращает объект класса View(общий предок для всех компонентов интерфейса), чтоб не было ошибок перед вызоыом метода указываем до какого компонента необходимо сузить возможности объекта View
        etInput = (EditText) findViewById(R.id.editTextNumber);
        bControl = (Button) findViewById(R.id.button);

        // узнать для чего (int)
        num = (int) (Math.random()*100);
        gameEnd = false;

        bControl.setOnClickListener(new View.OnClickListener() {
        // именно этот метод и отрабатывает при нажатии на кнопку, потому что мы его связали с ней
            public void onClick(View v) {
                if (!gameEnd) {
                    if (etInput.getText().toString() == "") {
                        tvInfo.setText(getResources().getString(R.string.no_input));
                    } else {
                        // получаем значение из input
                        int input_num = Integer.parseInt(etInput.getText().toString());
                        if (input_num >= 1 & input_num <= 100) {
                            if (input_num < num) {
                                // устанавливаем текст
                                tvInfo.setText(getResources().getString(R.string.behind));
                            } else if (input_num > num) {
                                tvInfo.setText(getResources().getString(R.string.ahead));
                            } else {
                                tvInfo.setText(getResources().getString(R.string.hit));
                            }
                        } else {
                            tvInfo.setText(getResources().getString(R.string.error));
                        }
                    }
                    bControl.setText(getResources().getString(R.string.play_more));
                    gameEnd = true;
                } else {
                    // когда хотим сыграть снова
                    gameEnd = false;
                    num = (int) (Math.random()*100);
                    bControl.setText(getResources().getString(R.string.input_value));
                    tvInfo.setText(getResources().getString(R.string.try_to_guess));
                }
                etInput.setText("");
            };
        });
    }
}