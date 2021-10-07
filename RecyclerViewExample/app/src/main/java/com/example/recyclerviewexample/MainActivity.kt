package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    lateinit var adapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var employeeList : ArrayList<Employee> = arrayListOf()
        employeeList.add(Employee(1, "Birgit", "Ceo", true))
        employeeList.add(Employee(2, "Børge", "Janitor", true))
        employeeList.add(Employee(3, "Bent", "Front End Developer", false))
        employeeList.add(Employee(4, "Bente", "Back End Developer", false))

        adapter =EmployeeAdapter(employeeList)

        var recyclerView: RecyclerView = findViewById(R.id.employeeView)
        recyclerView.setHasFixedSize(true)
        var layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //var layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter


    }
}