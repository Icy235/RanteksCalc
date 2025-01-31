
package com.example.rantekscalc;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;





public class WorkCalculate extends AppCompatActivity {
    private AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_calculate);

        appPrefs = new AppPrefs(this);

        EditText workTimeInput = findViewById(R.id.editTextWorkTime);
        workTimeInput.setText(appPrefs.getWorkTimeKey());
    }

    public void btnSave(View view) {
        EditText workTimeInput = findViewById(R.id.editTextWorkTime);
        String work_time = workTimeInput.getText().toString();

        appPrefs.setWorkTimeKey(work_time);

        // Перезапускаем CalculateMenu
        Intent intent = new Intent(this, CalculateMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Закрываем текущую Activity
    }

}
