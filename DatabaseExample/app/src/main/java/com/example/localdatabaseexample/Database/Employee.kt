package com.example.localdatabaseexample.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //(tableName = "EmployeeList")
data class Employee(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val firstName: String,
    val position: String,
    @ColumnInfo(name = "adminPrivilege") val admin: Boolean
)

// Automatic primary key generation example
/*
@Entity
data class Employee(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name") val firstName: String?,
    @ColumnInfo(name = "position") val position: String?,
    @ColumnInfo(name = "admin") val admin: Boolean?
)*/