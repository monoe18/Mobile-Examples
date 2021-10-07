package com.example.localdatabaseexample.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Employee::class), version = 1)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao

    companion object {
        private var INSTANCE: EmployeeDatabase? = null

        fun getAppDatabase(context: Context): EmployeeDatabase? {
            if (INSTANCE == null) {
                INSTANCE = databaseBuilder(context.applicationContext, EmployeeDatabase::class.java, "EmployeeDatabase")
                    //Do not allow main thread queries in your final prototypes!
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}