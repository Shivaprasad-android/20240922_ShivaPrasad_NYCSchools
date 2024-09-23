package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.School
import com.example.myapplication.repositorys.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val repository: Repository): ViewModel() {

    val _detaildData = MutableStateFlow<List<School>>(emptyList())

    var detailedData : StateFlow<List<School>> = _detaildData


   fun getSchoolDetails(id : String){

       viewModelScope.launch {
           repository.getSchoolDetails(id).collect(){
               _detaildData.value = it
           }
       }

   }



}