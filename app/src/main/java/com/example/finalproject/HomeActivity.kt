package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeActivity : AppCompatActivity(), OnReportClickListener {

    private lateinit var TaskRecyclerview: RecyclerView
    private var db = Firebase.firestore
    private lateinit var List: ArrayList<ReportModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
val logOut=findViewById<ImageButton>(R.id.logOut)
        TaskRecyclerview =findViewById(R.id.UserInfo)
        TaskRecyclerview.layoutManager = LinearLayoutManager(this)

        List = arrayListOf()
        db = FirebaseFirestore.getInstance()
        logOut.setOnClickListener{
            val intent=Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
        }

        db.collection("Users").get().addOnSuccessListener {
            if (!it.isEmpty) {

                for (task in it.documents) {
                    val t  = task.toObject(ReportModel::class.java)
                    if (t != null) {
                        List.add(t)
                    }
                }
                TaskRecyclerview.adapter = MyAdapter(List, this)
            }
        }
    }

    override fun onReportClicked(report: ReportModel) {
//        Toast.makeText(this, "Report" + position + "Clicked", Toast.LENGTH_LONG).show()
        val intent = Intent(this, ClickedRecycler::class.java)
        intent.putExtra("report", report)
        startActivity(intent)
    }
}

