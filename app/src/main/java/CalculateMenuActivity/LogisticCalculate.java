
package CalculateMenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rantekscalc.AppPrefs;
import com.example.rantekscalc.R;


public class LogisticCalculate extends AppCompatActivity {
    private AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistic_calculate);

        appPrefs = new AppPrefs(this);

        EditText distanceInput = findViewById(R.id.editTextDistance);
        distanceInput.setText(appPrefs.getDistance());

    }

    public void saveDistance(View view) {
        EditText distanceInput = findViewById(R.id.editTextDistance);
        String distance = distanceInput.getText().toString();

        appPrefs.setDistance(distance);

        // Перезапускаем CalculateMenu
        Intent intent = new Intent(this, CalculateMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Закрываем текущую Activity
    }

}
