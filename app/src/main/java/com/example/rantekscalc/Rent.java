package com.example.rantekscalc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Rent extends AppCompatActivity {
    private AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        appPrefs = new AppPrefs(this); // Инициализируем объект для работы с настройками

        EditText et = findViewById(R.id.editTextRent);
        et.setText(appPrefs.getRent()); // Загружаем сохраненное значение
    }

    public void saveRent(View view) {
        EditText rentBox = findViewById(R.id.editTextRent);
        String rent = rentBox.getText().toString();

        appPrefs.setRent(rent); // Сохраняем значение

        Intent myIntent = new Intent(this, CalculateMenu.class);
        startActivity(myIntent);
    }
}
