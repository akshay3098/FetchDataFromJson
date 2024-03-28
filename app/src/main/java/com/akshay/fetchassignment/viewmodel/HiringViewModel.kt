package com.akshay.fetchassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshay.fetchassignment.model.HiringListItem
import com.akshay.fetchassignment.repository.HiringRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

//Created a LiveData to Observe any changes in the data.
// It updates the State of the UI

@HiltViewModel
class HiringViewModel @Inject constructor(private val repo: HiringRepo) : ViewModel() {

    private val _data = MutableLiveData<List<HiringListItem>>()
    val data: LiveData<List<HiringListItem>> get() = _data


    fun getHiringDetails() {
        viewModelScope.launch(Dispatchers.IO) {

            val hiringList = repo.getHiring()
            _data.postValue(hiringList)

        }
    }

}

