package com.arun.mykotlin.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arun.mykotlin.R
import com.arun.mykotlin.databinding.ActivityFragmentsExBinding

class FragmentsEx : AppCompatActivity() {
    private val TAG = "FragmentsEx"

    lateinit var binding: ActivityFragmentsExBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFragmentsExBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, secondFragment)
            commit()
        }

        binding.btnFragments1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null)//when back press return to previous fragment
                commit()
            }
        }
        binding.btnFragments2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                commit()
            }
        }

    }
}