package SettingsMenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import TutorialActivity.HelperCalculate;
import com.example.rantekscalc.ProfileListMenu;
import com.example.rantekscalc.R;


public class SettingsPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);


    }

    public void btnLogistic(View view) {

        Intent myIntent = new Intent(this, LogisticPrice.class);
        startActivity(myIntent);

    }
    public void btnWork(View view) {

        Intent myIntent = new Intent(this, WorkSettings.class);
        startActivity(myIntent);

    }
    public void btnBack(View view) {

        Intent myIntent = new Intent(this, HelperCalculate.class);
        startActivity(myIntent);

    }
    public void btnMaterialCalcualte(View view) {

        Intent myIntent = new Intent(this, MaterialSelectSettings.class);
        startActivity(myIntent);

    }


    public void btnOther(View view) {

        Intent myIntent = new Intent(this, ProfileListMenu.class);
        startActivity(myIntent);

    }
}