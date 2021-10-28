package com.example.networkingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private var jsonData : List<Person>? = null
    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find textview
        textView = findViewById(R.id.person_display)

        //RetroFit Setup
        var retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.20.200:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var jsonAPI : PersonService = retrofit.create(PersonService::class.java);

        //data call
        var call : Call<List<Person>> = jsonAPI.getPersons();

        //remove from main thread
        call.enqueue(object : Callback<List<Person>> {
            override fun onResponse(
                call: Call<List<Person>>,
                response: Response<List<Person>>
            ) {
                //check if successful and save data
                if(!response.isSuccessful){
                    Log.i("netlog", "Code: " + response.code())
                    return
                }
                jsonData = response.body();
                Log.i("netlog", response.body().toString())
                runOnUiThread(Runnable { onDataReady()});
            }
            override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                Log.i("netlog", t.message.toString())
            }
        })
    }

    fun onDataReady(){
        var info = ""

        for(person in jsonData!!){
            Log.i("netlog", person.name + person.occupation + person.age.toString())
            info += "\nName: ${person.name} \nOccupation: ${person.occupation}\nAge: ${person.age}\n"
        }

        textView.text =info
    }
}