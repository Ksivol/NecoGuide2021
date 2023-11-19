package com.ksivol_project.necoguide2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.ksivol_project.necoguide2021.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && requestCode == RESULT_OK && data != null){

            bindingClass.tvMessageMain.text = data.getStringExtra("key2")

        }
    }

    fun onClickTest1(view: View){

        val i = Intent(this, TestActivity1::class.java)
        i.putExtra("key","Как тебя зовут?")
        startActivityForResult(i, 100)

    }

}