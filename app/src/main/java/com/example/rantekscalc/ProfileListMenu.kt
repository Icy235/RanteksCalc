package com.example.rantekscalc


import CalculateMenuActivity.CalculateMenu
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileListMenu : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var profileAdapter: ProfileAdapter
    private val profiles = mutableListOf<Profile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_main_menu)

        recyclerView = findViewById(R.id.recyclerViewProfiles)
        val btnAddProfile: ImageButton = findViewById(R.id.btnAddProfile)
        val btnBack: Button = findViewById(R.id.btnBack)

        // Настройка адаптера
        profileAdapter = ProfileAdapter(profiles,
            onDeleteClick = { position ->
                profiles.removeAt(position)
                profileAdapter.notifyItemRemoved(position)
                saveProfiles()
            },
            onProfileClick = { profile ->
                val intent = Intent(this, CalculateMenu::class.java)
                // Передаем все данные профиля
                intent.putExtra("profile_name", profile.name)
                intent.putExtra("workload", profile.workload)
                intent.putExtra("client", profile.client)
                intent.putExtra("total_price", profile.totalPrice)
                intent.putExtra("rent", profile.rent)
                intent.putExtra("markup", profile.markup)
                intent.putExtra("price_per_km", profile.pricePerKm)
                intent.putExtra("distance", profile.distance)
                intent.putExtra("material_mass", profile.materialMass)
                intent.putExtra("material_price", profile.materialPrice)
                intent.putExtra("work_time", profile.workTime)
                intent.putExtra("work_price", profile.workPrice)
                intent.putExtra("other_price", profile.otherPrice)

            },
            onProfileChangeListener = { position, profile ->
                saveProfiles() // Сохраняем изменения
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = profileAdapter

        // Обработчик добавления профиля
        btnAddProfile.setOnClickListener {
            val newProfile = Profile("", "", "", "0 р.")
            profiles.add(newProfile)
            profileAdapter.notifyItemInserted(profiles.size - 1)
            saveProfiles()
        }

        // Обработчик кнопки "Назад"
        btnBack.setOnClickListener {
            finish()
        }

        // Загрузка профилей
        loadProfiles()
    }

    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CALCULATE && resultCode == RESULT_OK) {
            val profileName = data?.getStringExtra("profile_name") ?: "Новый заказ"
            val profile = profiles.find { it.name == profileName }

            if (profile != null) {
                // Обновляем данные профиля
                if (data != null) {
                    profile.rent = data.getStringExtra("rent") ?: "0"
                }
                if (data != null) {
                    profile.markup = data.getStringExtra("markup") ?: "0"
                }
                if (data != null) {
                    profile.pricePerKm = data.getStringExtra("price_per_km") ?: "0"
                }
                if (data != null) {
                    profile.distance = data.getStringExtra("distance") ?: "0"
                }
                if (data != null) {
                    profile.materialMass = data.getStringExtra("material_mass") ?: "0"
                }
                if (data != null) {
                    profile.materialPrice = data.getStringExtra("material_price") ?: "0"
                }
                if (data != null) {
                    profile.workTime = data.getStringExtra("work_time") ?: "0"
                }
                if (data != null) {
                    profile.workPrice = data.getStringExtra("work_price") ?: "0"
                }
                if (data != null) {
                    profile.otherPrice = data.getStringExtra("other_price") ?: "0"
                }
                if (data != null) {
                    profile.totalPrice = data.getStringExtra("total_price") ?: "0 р."
                }

                profileAdapter.notifyDataSetChanged()
                saveProfiles()
            }
        }
    }

    private fun saveProfiles() {
        val sharedPreferences = getSharedPreferences("profiles", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val profileSet = profiles.map { profile ->
            "${profile.name}||${profile.workload}||${profile.client}||${profile.totalPrice}||" +
                    "${profile.rent}||${profile.markup}||${profile.pricePerKm}||${profile.distance}||" +
                    "${profile.materialMass}||${profile.materialPrice}||${profile.workTime}||${profile.workPrice}||${profile.otherPrice}"
        }.toSet()

        editor.putStringSet("profiles_list", profileSet)
        editor.apply()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadProfiles() {
        val sharedPreferences = getSharedPreferences("profiles", MODE_PRIVATE)
        val profileSet = sharedPreferences.getStringSet("profiles_list", emptySet()) ?: return

        profiles.clear()
        for (profileString in profileSet) {
            val parts = profileString.split("||")
            if (parts.size == 13) {
                val profile = Profile(
                    parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6],
                    parts[7], parts[8], parts[9], parts[10], parts[11], parts[12]
                )
                profiles.add(profile)
            }
        }
        profileAdapter.notifyDataSetChanged()
    }

    companion object {
        const val REQUEST_CODE_CALCULATE = 1001
    }

    fun btnCalculateMenuProfile(view: View?) {
        startActivity(Intent(this, CalculateMenu::class.java))
    }




}