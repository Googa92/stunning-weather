package com.example.valuedcustomer.weatherapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EdgeEffect
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moveToForecast = Intent (this,ForecastActivity::class.java)

        val searchEditText = findViewById<EditText>(R.id.searchEditText)

        val getForecastButton = findViewById<Button>(R.id.getForecastButton)
        getForecastButton.setOnClickListener {
            println("U r superman!")
            moveToForecast.putExtra("searchTerm",searchEditText.text.toString())
            startActivity(moveToForecast)

        }
    }
}
