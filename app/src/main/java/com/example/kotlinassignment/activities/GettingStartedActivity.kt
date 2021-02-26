package com.example.kotlinassignment.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinassignment.R
import kotlinx.android.synthetic.main.activity_getting_started.*

class GettingStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_started)
        supportActionBar?.hide()

        btnGo.setOnClickListener {
            val intent = Intent(applicationContext, MetricsActivity::class.java)
            startActivity(intent);
        }
    }
}