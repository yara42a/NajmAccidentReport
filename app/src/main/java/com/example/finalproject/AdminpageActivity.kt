package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class AdminpageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminpage)

        val login=findViewById<Button>(R.id.login)

        var PersonName = findViewById<EditText>(R.id.PersonName)
        var Password = findViewById<EditText>(R.id.Password)
        var loginViewModelx = ViewModelProvider(this)[loginViewModel::class.java]

        login.setOnClickListener {
            var name = PersonName.text.toString()
            //var password = Password.text.toString()
            if (loginViewModelx.person(PersonName.text.toString())&&loginViewModelx.pass(Password.text.toString())) {
                val intent= Intent(this, HomeActivity::class.java)
                intent.putExtra("PersonName",name)
                startActivity(intent)
            }else{
                Toast.makeText(this,"wrong name or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}