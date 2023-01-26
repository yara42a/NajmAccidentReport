package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val acc_page= findViewById<Button>(R.id.AccidentPage)
        val admn_page=findViewById<Button>(R.id.AdminPage)

        acc_page.setOnClickListener {
            val intent= Intent(this,ReportActivity::class.java)
            startActivity(intent)
        }

        admn_page.setOnClickListener {
            val intent= Intent(this,AdminpageActivity::class.java)
            startActivity(intent)
        }
    }
}