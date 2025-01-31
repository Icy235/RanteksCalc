package com.example.rantekscalc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MaterialSelectSettings extends AppCompatActivity {
    private AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_select_settings);

    }

    public void btnBack(View view) {
        Intent myIntent = new Intent(this, CalculateMenu.class);
        startActivity(myIntent);
    }


    public void btnMaterialPrice(View view) {
        Intent myIntent = new Intent(this, MaterialSettings.class);
        startActivity(myIntent);
    }


    public void btnMaterialName(View view) {
        Intent myIntent = new Intent(this, MaterialNameSettings.class);
        startActivity(myIntent);
    }
}
