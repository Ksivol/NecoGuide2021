package com.ksivol_project.necoguide2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onClickTest(view: View) {
        val tvTest = findViewById<TextView>(R.id.tvTest)
        tvTest.text = "privet"
    }

}