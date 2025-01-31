package com.example.rantekscalc;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPrefs {
    private static final String PREFS_NAME = "AppPrefs"; // Имя файла настроек
    private static final String RENT_KEY = "rent_value"; // Ключ для аренды
    private static final String MARKUP_KEY = "markup_value"; // Ключ для наценки
    private static final String PRICE_PER_KM_KEY = "price_per_km"; // Цена за 1 км
    private static final String DISTANCE_KEY = "distance"; // Количество км
    private static final String MASS_MATERIAL_KEY = "material_mass"; // Количество материала
    private static final String PRICE_MATERIAL_KEY = "material_price"; // цена за кг
    private static final String WORK_TIME_KEY = "work_time"; // кол-во дней работы
    private static final String WORK_PRICE_KEY = "work_price"; // цена за день работы
    private static final String MATERIAL_1_PRICE_KEY = "material_1_price_per_kg"; // цена за кг материала 1
    private static final String MATERIAL_2_PRICE_KEY = "material_2_price_per_kg"; // цена за кг материала 2
    private static final String MATERIAL_3_PRICE_KEY = "material_3_price_per_kg"; // цена за кг материала 3
    private static final String MATERIAL_4_PRICE_KEY = "material_4_price_per_kg"; // цена за кг материала 4
    private static final String OTHER_PRICE_KEY = "other_price"; // прочая цена

    private static final String MATERIAL_1_NAME_KEY = "material_1_name"; // название материала 1
    private static final String MATERIAL_2_NAME_KEY = "material_2_name"; // название материала 1
    private static final String MATERIAL_3_NAME_KEY = "material_3_name"; // название материала 1
    private static final String MATERIAL_4_NAME_KEY = "material_4_name"; // название материала 1

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public AppPrefs(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // Методы для работы с "Арендой"
    public void setRent(String rent) {
        editor.putString(RENT_KEY, rent);
        editor.apply();
    }

    public String getRent() {
        return sharedPreferences.getString(RENT_KEY, "0"); // Возвращаем сохраненное значение или "ошибку"
    }

    // Методы для работы с "Наценкой"
    public void setMarkup(String markup) {
        editor.putString(MARKUP_KEY, markup);
        editor.apply();
    }

    public String getMarkup() {
        return sharedPreferences.getString(MARKUP_KEY, "0"); // Возвращаем сохраненное значение или "ошибку"
    }


    public void setPricePerKm(String price) {
        editor.putString(PRICE_PER_KM_KEY, price);
        editor.apply();
    }

    public String getPricePerKm() {
        return sharedPreferences.getString(PRICE_PER_KM_KEY, "0");// Возвращаем сохраненное значение или "ошибку"
    }

    public void setDistance(String distance) {
        editor.putString(DISTANCE_KEY, distance);
        editor.apply();
    }

    public String getDistance() {
        return sharedPreferences.getString(DISTANCE_KEY, "0");// Возвращаем сохраненное значение или "ошибку"
    }


    public void setMassMaterialKey(String price) {
        editor.putString(MASS_MATERIAL_KEY, price);
        editor.apply();
    }

    public String getMassMaterialKey() {
        return sharedPreferences.getString(MASS_MATERIAL_KEY, "0");// Возвращаем сохраненное значение или "ошибку"
    }

    public void setPriceMaterialKey(String price) {
        editor.putString(PRICE_MATERIAL_KEY, price);
        editor.apply();
    }

    public String getPriceMaterialKey() {
        return sharedPreferences.getString(PRICE_MATERIAL_KEY, "0");// Возвращаем сохраненное значение или "ошибку"
    }

    public void setWorkTimeKey(String markup) {
        editor.putString(WORK_TIME_KEY, markup);
        editor.apply();
    }

    public String getWorkTimeKey() {
        return sharedPreferences.getString(WORK_TIME_KEY, "0"); // Возвращаем сохраненное значение или "ошибку"
    }

    public void setWorkPriceKey(String markup) {
        editor.putString(WORK_PRICE_KEY, markup);
        editor.apply();
    }

    public String getWorkPriceKey() {
        return sharedPreferences.getString(WORK_PRICE_KEY, "0"); // Возвращаем сохраненное значение или "ошибку"
    }



    public void setMaterial1PriceKey(String markup) {
        editor.putString(MATERIAL_1_PRICE_KEY, markup);
        editor.apply();
    }

    public String getMaterial1PriceKey() {
        return sharedPreferences.getString(MATERIAL_1_PRICE_KEY, "0"); // Возвращаем сохраненное значение или "ошибку"
    }

    public void setMaterial2PriceKey(String markup) {
        editor.putString(MATERIAL_2_PRICE_KEY, markup);
        editor.apply();
    }

    public String getMaterial2PriceKey() {
        return sharedPreferences.getString(MATERIAL_2_PRICE_KEY, "0"); // Возвращаем сохраненное значение или "ошибку"
    }

    public void setMaterial3PriceKey(String markup) {
        editor.putString(MATERIAL_3_PRICE_KEY, markup);
        editor.apply();
    }

    public String getMaterial3PriceKey() {
        return sharedPreferences.getString(MATERIAL_3_PRICE_KEY, "0"); // Возвращаем сохраненное значение или "ошибку"
    }

    public void setMaterial4PriceKey(String markup) {
        editor.putString(MATERIAL_4_PRICE_KEY, markup);
        editor.apply();
    }

    public String getMaterial4PriceKey() {
        return sharedPreferences.getString(MATERIAL_4_PRICE_KEY, "0"); // Возвращаем сохраненное значение или "ошибку"
    }



    public void setOtherPriceKey(String markup) {
        editor.putString(OTHER_PRICE_KEY, markup);
        editor.apply();
    }

    public String getOtherPriceKey() {
        return sharedPreferences.getString(OTHER_PRICE_KEY, "0"); // Возвращаем сохраненное значение или "ошибку"
    }


    public void setMaterial1NameKey(String markup) {
        editor.putString(MATERIAL_1_NAME_KEY, markup);
        editor.apply();
    }

    public String getMaterial1NameKey() {
        return sharedPreferences.getString(MATERIAL_1_NAME_KEY, "Пусто"); // Возвращаем сохраненное значение или "ошибку"
    }

    public void setMaterial2NameKey(String markup) {
        editor.putString(MATERIAL_2_NAME_KEY, markup);
        editor.apply();
    }

    public String getMaterial2NameKey() {
        return sharedPreferences.getString(MATERIAL_2_NAME_KEY, "Пусто"); // Возвращаем сохраненное значение или "ошибку"
    }

    public void setMaterial3NameKey(String markup) {
        editor.putString(MATERIAL_3_NAME_KEY, markup);
        editor.apply();
    }

    public String getMaterial3NameKey() {
        return sharedPreferences.getString(MATERIAL_3_NAME_KEY, "Пусто"); // Возвращаем сохраненное значение или "ошибку"
    }

    public void setMaterial4NameKey(String markup) {
        editor.putString(MATERIAL_4_NAME_KEY, markup);
        editor.apply();
    }

    public String getMaterial4NameKey() {
        return sharedPreferences.getString(MATERIAL_4_NAME_KEY, "Пусто"); // Возвращаем сохраненное значение или "ошибку"
    }

}