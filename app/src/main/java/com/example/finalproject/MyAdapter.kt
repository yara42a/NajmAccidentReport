package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val UserInfo: ArrayList<ReportModel>,
                private val onReportClickListener: OnReportClickListener
): RecyclerView.Adapter<MyAdapter.myViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(LayoutInflater.from(parent.context).inflate
            (R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val CurrentTask = UserInfo[position]
        holder.bind(CurrentTask)
//        holder.FName.text = CurrentTask.firstName.toString()
//        holder.FPNumber.text = CurrentTask.firstPhoneNum.toString()
//        holder.itemView.setOnClickListener {
//            onReportClickListener.onReportClicked(position)
//        }
    }

    override fun getItemCount(): Int {
        return UserInfo.size
    }

    inner class myViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        private val FName: TextView = itemView.findViewById(R.id.firstName)
        private val FPNumber: TextView = itemView.findViewById(R.id.phoneShow)

        fun bind(report: ReportModel) {
            FName.text = report.firstName.toString()
            FPNumber.text = report.firstPhoneNum.toString()

            itemView.setOnClickListener {
                onReportClickListener.onReportClicked(report)
            }
        }
    }
}
