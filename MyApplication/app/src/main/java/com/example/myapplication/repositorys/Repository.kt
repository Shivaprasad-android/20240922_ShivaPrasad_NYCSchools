package com.example.myapplication.repositorys

import com.example.myapplication.api_services.ApiServices
import com.example.myapplication.data.School
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(val apiServices: ApiServices) {
    fun getSchoolList(): Flow<List<School>> = flow {
       emit( apiServices.getSchoolList())
    }

    fun getSchoolDetails( id :String): Flow<List<School>> = flow {
        emit(apiServices.getSchoolDetails(id))
    }
}