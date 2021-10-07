package com.example.localdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.localdatabaseexample.Database.Employee
import com.example.localdatabaseexample.Database.EmployeeDatabase

class MainActivity : AppCompatActivity() {
    lateinit var db : EmployeeDatabase

    private lateinit var numbers: EditText
    private lateinit var attributes : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = EmployeeDatabase.getAppDatabase(this)!!

        numbers = findViewById<EditText>(R.id.editTextNumber)
        attributes = findViewById(R.id.Attributes)

        //Populates database if empty
        if(db.employeeDao().getAll().isEmpty()){
            Log.i("DatabaseTest", "Ran Database Population")
            var employee1 = Employee(1, "Jens", "Server Tech", false)
            var employee2 = Employee(2, "Birgit", "CEO", true)
            var employee3 = Employee(3, "Chris", "Restaurant Cashier", false)
            var employee4 = Employee(4, "Børge", "Design Lead", true)

            db.employeeDao().insert(employee1)
            db.employeeDao().insert(employee2)
            db.employeeDao().insert(employee3)
            db.employeeDao().insert(employee4)
        }
    }

//Takes a number from the UI and shows the related information
    fun showEmployee(view: View){
        var employee = db.employeeDao().loadByID(numbers.text.toString().toInt())
        attributes.text = "Name: " + employee.firstName + "\nPosition: " + employee.position + "\nAdmin Status: " + employee.admin
    }
}