package com.example.deliveryshareapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}