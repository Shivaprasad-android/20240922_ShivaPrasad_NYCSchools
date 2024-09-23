package com.example.myapplication.api_services

import com.example.myapplication.data.School
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("s3k6-pzi2.json")
    suspend fun getSchoolList():List<School>

    @GET("s3k6-pzi2.json")
    suspend fun getSchoolDetails(@Query("dbn") id :String):List<School>


}