package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(private val data : ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    inner class ViewHolder(item : View): RecyclerView.ViewHolder(item){
        val employeeID : TextView = item.findViewById(R.id.employeeID)
        val employeeName : TextView = item.findViewById(R.id.name)
        val employeePos : TextView = item.findViewById(R.id.position)
        val atWork : CheckBox = item.findViewById(R.id.atWork)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_view_holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.employeeID.text =data[position].employeeID.toString()
        holder.employeeName.text = data[position].name
        holder.employeePos.text =data[position].position
        if(data[position].atWork){
            holder.atWork.isChecked = true
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}