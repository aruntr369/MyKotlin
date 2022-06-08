package com.arun.mykotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn :Button = findViewById(R.id.btn)
        val eta :EditText = findViewById(R.id.eta)
        val etb :EditText = findViewById(R.id.etb)
        var tvResult :TextView =findViewById(R.id.tvResult)

        btn.setOnClickListener {
            val a =eta.text.toString().toInt()
            val b =etb.text.toString().toInt()
            val c=a+b
            tvResult.text=c.toString()

        }
        //for image
        val btnimj :Button =findViewById(R.id.btnaddImj)
        var iv :ImageView = findViewById(R.id.imageView)
        btnimj.setOnClickListener {
            iv.setImageResource(R.drawable.ic_launcher_foreground)
        }

        val btnSecond: Button = findViewById(R.id.btnSec)
        btnSecond.setOnClickListener {
            var i :Intent=Intent(this, secondAct::class.java)
                startActivity(i)

        }
    }
}