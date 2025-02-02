
package com.example.rantekscalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;





public class MaterialSettings extends AppCompatActivity {
    private AppPrefs appPrefs;






    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_settings);

        appPrefs = new AppPrefs(this);

        EditText Material1Input = findViewById(R.id.editTextMaterial1);
        Material1Input.setText(appPrefs.getMaterial1PriceKey());

        EditText Material2Input = findViewById(R.id.editTextMaterial2);
        Material2Input.setText(appPrefs.getMaterial2PriceKey());

        EditText Material3Input = findViewById(R.id.editTextMaterial3);
        Material3Input.setText(appPrefs.getMaterial3PriceKey());

        EditText Material4Input = findViewById(R.id.editTextMaterial4);
        Material4Input.setText(appPrefs.getMaterial4PriceKey());


        TextView Material1Text = findViewById(R.id.textViewMaterial1);
        Material1Text.setText("Цена за кг " + appPrefs.getMaterial1NameKey());

        TextView Material2Text = findViewById(R.id.textViewMaterial2);
        Material2Text.setText("Цена за кг " + appPrefs.getMaterial2NameKey());

        TextView Material3Text = findViewById(R.id.textViewMaterial3);
        Material3Text.setText("Цена за кг " + appPrefs.getMaterial3NameKey());

        TextView Material4Text = findViewById(R.id.textViewMaterial4);
        Material4Text.setText("Цена за кг " + appPrefs.getMaterial4NameKey());

    }

    public void btnSave(View view) {

        EditText Material1Input = findViewById(R.id.editTextMaterial1);
        String material_1_price_per_kg = Material1Input.getText().toString();
        appPrefs.setMaterial1PriceKey(material_1_price_per_kg);

        EditText Material2Input = findViewById(R.id.editTextMaterial2);
        String material_2_price_per_kg = Material2Input.getText().toString();
        appPrefs.setMaterial2PriceKey(material_2_price_per_kg);

        EditText Material3Input = findViewById(R.id.editTextMaterial3);
        String material_3_price_per_kg = Material3Input.getText().toString();
        appPrefs.setMaterial3PriceKey(material_3_price_per_kg);

        EditText Material4Input = findViewById(R.id.editTextMaterial4);
        String material_4_price_per_kg = Material4Input.getText().toString();
        appPrefs.setMaterial4PriceKey(material_4_price_per_kg);

        // Перезапускаем CalculateMenu
        Intent intent = new Intent(this, MaterialSelectSettings.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Закрываем текущую Activity
    }





}
