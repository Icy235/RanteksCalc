package SettingsMenuActivity;



import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.rantekscalc.R;

public class MaterialSelectSettings extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_select_settings);



    }

    public void btnBack(View view) {
        Intent myIntent = new Intent(this, SettingsPage.class);
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
