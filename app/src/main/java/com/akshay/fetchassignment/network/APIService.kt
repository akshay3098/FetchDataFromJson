package com.akshay.fetchassignment.network

import com.akshay.fetchassignment.model.HiringListItem
import retrofit2.http.GET

//This is the API class
//Used GET to fetch the data from the API

interface APIService {

    @GET("hiring.json")
    suspend fun getHiringDetails(): List<HiringListItem>
}