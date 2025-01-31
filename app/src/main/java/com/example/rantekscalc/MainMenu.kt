package com.example.rantekscalc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.rantekscalc.databinding.ActivityMainMenuBinding

class MainMenu : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)




        binding.btnCalculate.setOnClickListener{

            val intent = Intent(this@MainMenu, CalculateMenu:: class.java)
            startActivity(intent)
        }

        binding.btnSettings.setOnClickListener{

            val intent = Intent(this@MainMenu, SettingsPage:: class.java)
            startActivity(intent)
        }


        binding.btnChangeLog.setOnClickListener{

            val intent = Intent(this@MainMenu, ChangeLog:: class.java)
            startActivity(intent)
        }


    }
        }
