
package SettingsMenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rantekscalc.AppPrefs;
import com.example.rantekscalc.R;


public class MaterialNameSettings extends AppCompatActivity {
    private AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_name_settings);

        appPrefs = new AppPrefs(this);



        EditText Material1Name = findViewById(R.id.editTextMaterial1);
        Material1Name.setText(appPrefs.getMaterial1NameKey());

        EditText Material2Name = findViewById(R.id.editTextMaterial2);
        Material2Name.setText(appPrefs.getMaterial2NameKey());

        EditText Material3Name = findViewById(R.id.editTextMaterial3);
        Material3Name.setText(appPrefs.getMaterial3NameKey());

        EditText Material4Name = findViewById(R.id.editTextMaterial4);
        Material4Name.setText(appPrefs.getMaterial4NameKey());



    }

    public void btnSave(View view) {

        EditText MaterialName1Input = findViewById(R.id.editTextMaterial1);
        String material_1_name = MaterialName1Input.getText().toString();
        appPrefs.setMaterial1NameKey(material_1_name);

        EditText MaterialName2Input = findViewById(R.id.editTextMaterial2);
        String material_2_name = MaterialName2Input.getText().toString();
        appPrefs.setMaterial2NameKey(material_2_name);

        EditText MaterialName3Input = findViewById(R.id.editTextMaterial3);
        String material_3_name = MaterialName3Input.getText().toString();
        appPrefs.setMaterial3NameKey(material_3_name);

        EditText MaterialName4Input = findViewById(R.id.editTextMaterial4);
        String material_4_name = MaterialName4Input.getText().toString();
        appPrefs.setMaterial4NameKey(material_4_name);

        // Перезапускаем CalculateMenu
        Intent intent = new Intent(this, MaterialSelectSettings.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Закрываем текущую Activity
    }





}
