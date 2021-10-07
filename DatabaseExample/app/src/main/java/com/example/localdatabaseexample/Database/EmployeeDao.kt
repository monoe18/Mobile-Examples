package com.example.localdatabaseexample.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM Employee")
    fun getAll(): List<Employee>

    @Query("SELECT * FROM Employee WHERE :employeeID = id")
    fun loadByID(employeeID: Int): Employee

    @Insert
    fun insert(employee: Employee)

    @Delete
    fun delete(employee: Employee)
}