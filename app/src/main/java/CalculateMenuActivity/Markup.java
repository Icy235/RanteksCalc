package CalculateMenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rantekscalc.AppPrefs;
import com.example.rantekscalc.R;

public class Markup extends AppCompatActivity {
    private AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markup);

        appPrefs = new AppPrefs(this);

        EditText et = findViewById(R.id.editTextMarkup);
        et.setText(appPrefs.getMarkup()); // Загружаем сохраненное значение

    }

    public void saveMarkup(View view) {
        EditText markupBox = findViewById(R.id.editTextMarkup);
        String markup = markupBox.getText().toString();

        appPrefs.setMarkup(markup); // Сохраняем значение

        Intent myIntent = new Intent(this, CalculateMenu.class);
        startActivity(myIntent);
    }
}
