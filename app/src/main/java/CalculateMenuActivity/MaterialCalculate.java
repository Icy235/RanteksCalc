package CalculateMenuActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rantekscalc.AppPrefs;
import CalculateMenuActivity.MaterialAdapter.MaterialAdapter;
import com.example.rantekscalc.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaterialCalculate extends AppCompatActivity {
    private AppPrefs appPrefs;
    private RecyclerView recyclerView;
    private MaterialAdapter adapter;
    private Button selectMaterialButton;
    private EditText editTextPricePerKg;
    private List<String> items;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_calculalte);

        appPrefs = new AppPrefs(this);
        selectMaterialButton = findViewById(R.id.selectMaterialButton);
        editTextPricePerKg = findViewById(R.id.editTextPricePerKg);

        EditText materialMass = findViewById(R.id.editTextMaterialMass);
        materialMass.setText(appPrefs.getMassMaterialKey());

        EditText materialPrice = findViewById(R.id.editTextPricePerKg);
        materialPrice.setText(appPrefs.getPriceMaterialKey());

        selectMaterialButton.setOnClickListener(view -> showBottomSheet());

    }

    private void showBottomSheet() {
        @SuppressLint("InflateParams") View bottomSheetView = LayoutInflater.from(MaterialCalculate.this)
                .inflate(R.layout.bottom_sheet_materials, null);
        recyclerView = bottomSheetView.findViewById(R.id.recyclerViewMaterials);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        items = new ArrayList<>();
        items.add(appPrefs.getMaterial1NameKey());
        items.add(appPrefs.getMaterial2NameKey());
        items.add(appPrefs.getMaterial3NameKey());
        items.add(appPrefs.getMaterial4NameKey());

        adapter = new MaterialAdapter(items, material -> {
            selectMaterialButton.setText(material);
            int price = getMaterialPrice(material);
            editTextPricePerKg.setText(String.valueOf(price));
            return null;
        });

        recyclerView.setAdapter(adapter);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MaterialCalculate.this);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private int getMaterialPrice(String material) {
        Map<String, String> materialPrices = new HashMap<>();
        materialPrices.put(appPrefs.getMaterial1NameKey(), appPrefs.getMaterial1PriceKey());
        materialPrices.put(appPrefs.getMaterial2NameKey(), appPrefs.getMaterial2PriceKey());
        materialPrices.put(appPrefs.getMaterial3NameKey(), appPrefs.getMaterial3PriceKey());
        materialPrices.put(appPrefs.getMaterial4NameKey(), appPrefs.getMaterial4PriceKey());

        String priceString = materialPrices.getOrDefault(material, "40");

        try {
            assert priceString != null;
            return Integer.parseInt(priceString);
        } catch (NumberFormatException e) {
            return 40;
        }
    }

    public void saveMaterial(View view) {
        EditText materialPriceInput = findViewById(R.id.editTextPricePerKg);
        String materialPrice = materialPriceInput.getText().toString();

        EditText materialMassInput = findViewById(R.id.editTextMaterialMass);
        String materialMass = materialMassInput.getText().toString();

        appPrefs.setMassMaterialKey(materialMass);
        appPrefs.setPriceMaterialKey(materialPrice);

        Intent intent = new Intent(this, CalculateMenu.class);
        startActivity(intent);
        finish();
    }
}
