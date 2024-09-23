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
class ListViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    private val _list = MutableStateFlow<List<School>>(emptyList())

    var list: StateFlow<List<School>> = _list

    init {
        getSchoolList()
    }

    private fun getSchoolList(){
        viewModelScope.launch {
            repository.getSchoolList().collect(){
                _list.value = it
            }
        }
    }

}