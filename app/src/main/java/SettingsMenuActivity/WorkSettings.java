
package SettingsMenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rantekscalc.AppPrefs;
import com.example.rantekscalc.R;


public class WorkSettings extends AppCompatActivity {
    private AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_settings);

        appPrefs = new AppPrefs(this);

        EditText workPriceInput = findViewById(R.id.editTextWorkPrice);
        workPriceInput.setText(appPrefs.getWorkPriceKey());

    }

    public void btnSave(View view) {
        EditText workPriceInput = findViewById(R.id.editTextWorkPrice);
        String work_price = workPriceInput.getText().toString();

        appPrefs.setWorkPriceKey(work_price);

        // Перезапускаем CalculateMenu
        Intent intent = new Intent(this, SettingsPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Закрываем текущую Activity
    }

}
