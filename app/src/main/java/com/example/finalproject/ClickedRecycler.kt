package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class ClickedRecycler : AppCompatActivity() {

    private lateinit var firstName: TextView
    private lateinit var firstPhoneNum:TextView
    private lateinit var firstCarNum:TextView
    private lateinit var Check1:TextView
    private lateinit var Secondtname:TextView
    private lateinit var SecondPNum:TextView
    private lateinit var SecondCarNum:TextView
    private lateinit var Check2:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clicked_recycler)

        firstName = findViewById(R.id.firstName)
        firstPhoneNum=findViewById(R.id.firstPhoneNum)
        firstCarNum=findViewById(R.id.firstCarNum)
        Check1=findViewById(R.id.Check1)
        Secondtname=findViewById(R.id.Secondtname)
        SecondPNum=findViewById(R.id.SecondPNum)
        SecondCarNum=findViewById(R.id.SecondCarNum)
        Check2=findViewById(R.id.Check2)
        var toolbar = findViewById<Toolbar>(R.id.toolBar)

        toolbar.setNavigationOnClickListener{
            finish()
        }


        val report = intent.getParcelableExtra("report") as ReportModel?
//        Log.d("TAG", "onCreate: $report")
        //val report=intent.getParcelableExtra<ReportModel>("report")

//        val result=StringBuilder()
//        result.append("")
//        if(Check1.isChecked) result.append("Yes") else result.append("No")
//        if(Check2.isChecked) result.append("Yes") else result.append("No")
        firstName.text = report?.firstName
        firstPhoneNum.text=report?.firstPhoneNum
        firstCarNum.text=report?.firstCarNum
        Check1.text=report?.Check1
        Secondtname.text=report?.Secondtname
        SecondPNum.text=report?.SecondPNum
        SecondCarNum.text=report?.SecondCarNum
        Check2.text=report?.Check2


    }
}