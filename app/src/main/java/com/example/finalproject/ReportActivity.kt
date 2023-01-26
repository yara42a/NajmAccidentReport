package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class ReportActivity : AppCompatActivity() {
    private lateinit var fName: EditText
    private lateinit var FPNumber: EditText
    private lateinit var CNum1: EditText
    private lateinit var checkBox1:CheckBox

    private lateinit var sName: EditText
    private lateinit var SPNumber: EditText
    private lateinit var CNum2: EditText
    private lateinit var checkBox2:CheckBox
    private lateinit var cancel:ImageButton

    private lateinit var submit: Button
    private var db=Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

         submit=findViewById<Button>(R.id.submit)

        fName=findViewById(R.id.name1)
        FPNumber=findViewById(R.id.phonenum1)
        CNum1=findViewById(R.id.carNum1)
        checkBox1=findViewById(R.id.checkBox1)

        sName=findViewById(R.id.name2)
        SPNumber=findViewById(R.id.phonenum2)
        CNum2=findViewById(R.id.carNum2)
        checkBox2=findViewById(R.id.checkBox2)
        cancel=findViewById(R.id.cancel)

        cancel.setOnClickListener {
            val intent=Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
        }


        submit.setOnClickListener {

            var FirstName=fName.text.toString().trim()
            var FirstPNum=FPNumber.text.toString().trim()
            var FirstCarNum=CNum1.text.toString().trim()
            var Check1=if (checkBox1.isChecked) "Yes" else "No"

            var Secondtname=sName.text.toString().trim()
            var SecondPNum=SPNumber.text.toString().trim()
            var SecondCarNum=CNum2.text.toString().trim()
            var Check2 = if (checkBox2.isChecked) "Yes" else "No"

            val userInfoMap= hashMapOf(
                "firstName" to FirstName,
                "firstPhoneNum" to FirstPNum,
                "firstCarNum" to FirstCarNum,
                "Check1" to Check1,
                "Secondtname" to Secondtname,
                "SecondPNum" to SecondPNum,
                "SecondCarNum" to SecondCarNum,
                "Check2" to Check2
            )


            db.collection("Users").document().set(userInfoMap).addOnSuccessListener {
                Toast.makeText(this,"Successfully inserted", Toast.LENGTH_SHORT).show()
                fName.text.clear()
                FPNumber.text.clear()
                CNum1.text.clear()
                checkBox1.text

                sName.text.clear()
                SPNumber.text.clear()
                CNum2.text.clear()
                checkBox2.text
                val intent = Intent(this, LastActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener{
                Toast.makeText(this,"Failed inserted", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }