package CalculateMenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.rantekscalc.AppPrefs;
import com.example.rantekscalc.MainMenu;
import com.example.rantekscalc.R;

public class CalculateMenu extends AppCompatActivity {
    private AppPrefs appPrefs;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_menu);


        appPrefs = new AppPrefs(this);

        // Получаем данные, указывая "0" по умолчанию
        double rentValue = Double.parseDouble(appPrefs.getRent().isEmpty() ? "0" : appPrefs.getRent());
        double markupPercent = Double.parseDouble(appPrefs.getMarkup().isEmpty() ? "0" : appPrefs.getMarkup());
        double pricePerKm = Double.parseDouble(appPrefs.getPricePerKm().isEmpty() ? "0" : appPrefs.getPricePerKm());
        double distance = Double.parseDouble(appPrefs.getDistance().isEmpty() ? "0" : appPrefs.getDistance());
        double material_price = Double.parseDouble(appPrefs.getPriceMaterialKey().isEmpty() ? "0" : appPrefs.getPriceMaterialKey());
        double material_mass = Double.parseDouble(appPrefs.getMassMaterialKey().isEmpty() ? "0" : appPrefs.getMassMaterialKey());
        double workTime = Double.parseDouble(appPrefs.getWorkTimeKey().isEmpty() ? "0" : appPrefs.getWorkTimeKey());
        double workPrice = Double.parseDouble(appPrefs.getWorkPriceKey().isEmpty() ? "0" : appPrefs.getWorkPriceKey());
        double otherPrice = Double.parseDouble(appPrefs.getOtherPriceKey().isEmpty() ? "0" : appPrefs.getOtherPriceKey());

        //Трудозатраты
        double totalWork = workTime * workPrice;

        // Материал
        double totalMaterial = material_mass * material_price;

        // Аренда
        double rentDay = rentValue / 27;
        double totalRent = workTime * rentDay;


        // Логистика
        double totalLogistics = pricePerKm * distance;

        // Итоговый расчет
        double markupValue = (totalRent + totalLogistics + totalMaterial + totalWork + otherPrice) * (markupPercent / 100);
        double totalCost = totalRent + totalLogistics + markupValue + totalMaterial + totalWork + otherPrice;





        // Добавляю пояснение вывода руб.


        TextView materialView = findViewById(R.id.viewTextMaterial);
        materialView.setText(String.format("%.2f руб.", totalMaterial));

        TextView workView = findViewById(R.id.viewTextWork);
        workView.setText(String.format("%.2f руб.", totalWork));

        TextView rentView = findViewById(R.id.viewTextRent);
        rentView.setText(String.format("%.2f руб.", totalRent));

        TextView logisticView = findViewById(R.id.viewTextLogisticCost);
        logisticView.setText(String.format("%.2f руб.", totalLogistics));

        TextView otherView = findViewById(R.id.viewTextOther);
        otherView.setText(String.format("%.2f руб.", otherPrice));


        TextView markupView = findViewById(R.id.viewTextMarkup);
        markupView.setText(String.format("%.2f руб.", markupValue));

        TextView totalView = findViewById(R.id.viewTextResult);
        totalView.setText(String.format("%.2f руб.", totalCost));



    }

    public void btnRent(View view) {
        startActivity(new Intent(this, Rent.class));
    }

    public void btnMarkup(View view) {
        startActivity(new Intent(this, Markup.class));
    }

    public void btnLogisticCalculate(View view) {
        startActivity(new Intent(this, LogisticCalculate.class));
    }

    public void btnMaterial(View view) {
        startActivity(new Intent(this, MaterialCalculate.class));
    }

    public void btnWork(View view) {
        startActivity(new Intent(this, WorkCalculate.class));
    }

    public void btnOther(View view) {
        startActivity(new Intent(this, Other.class));
    }

    public void btnBack(View view) {
        startActivity(new Intent(this, MainMenu.class));
    }



}
