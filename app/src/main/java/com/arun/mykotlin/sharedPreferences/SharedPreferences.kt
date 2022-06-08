package com.arun.mykotlin.sharedPreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arun.mykotlin.R
import com.arun.mykotlin.databinding.ActivitySharedPreferencesBinding

class SharedPreferences : AppCompatActivity() {
    lateinit var binding: ActivitySharedPreferencesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toInt()
            val isAdult = binding.cbAdult.isChecked

            editor.apply {
                putString("name",name)
                putInt("age",age)
                putBoolean("isAdult",isAdult)
                apply()
            }
        }

        binding.btnLoad.setOnClickListener {
            val name = sharedPref.getString("name",null)
            val age = sharedPref.getInt("age",0)
            val isAdult = sharedPref.getBoolean("isAdult",false)

            binding.etName.setText(name)
            binding.etAge.setText(age.toString())
            binding.cbAdult.isChecked = isAdult
        }

    }

}