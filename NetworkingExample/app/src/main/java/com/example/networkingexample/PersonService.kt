package com.example.networkingexample

import retrofit2.Call
import retrofit2.http.GET

interface PersonService {
    @GET("/")
    fun getPersons() : Call<List<Person>>;
}