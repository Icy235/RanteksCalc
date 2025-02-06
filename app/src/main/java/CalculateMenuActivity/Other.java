package CalculateMenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rantekscalc.AppPrefs;
import com.example.rantekscalc.R;

public class Other extends AppCompatActivity {
    private AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        appPrefs = new AppPrefs(this); // Инициализируем объект для работы с настройками


        EditText OtherInput = findViewById(R.id.priceOther);
        OtherInput.setText(appPrefs.getOtherPriceKey());

    }

    public void btnBack(View view) {
        EditText OtherInput = findViewById(R.id.priceOther);
        String other_price = OtherInput.getText().toString();

        appPrefs.setOtherPriceKey(other_price);


        // Перезапускаем CalculateMenu
        Intent intent = new Intent(this, CalculateMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        finish();
    }
}
