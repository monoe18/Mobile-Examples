package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            add(R.id.fragmentContainerView,Green_Fragment())
            setReorderingAllowed(true)}
        }

    fun SwitchFragment(view: android.view.View) {
        supportFragmentManager.commit {
        replace(R.id.fragmentContainerView,Red_Fragment())
        setReorderingAllowed(true)}}

}