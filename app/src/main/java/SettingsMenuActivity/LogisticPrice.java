package SettingsMenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rantekscalc.AppPrefs;
import com.example.rantekscalc.R;

public class LogisticPrice extends AppCompatActivity {
    private AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logisctic_price);

        appPrefs = new AppPrefs(this); // Инициализируем объект для работы с настройками


        EditText pricePerKmInput = findViewById(R.id.pricePerKm);
        pricePerKmInput.setText(appPrefs.getPricePerKm());

    }

    public void savePricePerKm(View view) {
        EditText pricePerKmInput = findViewById(R.id.pricePerKm);
        String pricePerKm = pricePerKmInput.getText().toString();

        appPrefs.setPricePerKm(pricePerKm);

        finish();
    }
}
