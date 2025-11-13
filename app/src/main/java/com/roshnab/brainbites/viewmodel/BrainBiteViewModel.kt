package com.roshnab.brainbites.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roshnab.brainbites.data.Bite
import kotlinx.coroutines.launch
import android.util.Log
import androidx.lifecycle.asLiveData

class BrainBiteViewModel(private val repository: BitesRepository) : ViewModel() {
    val bites = repository.biteDao.getAllBites()

    init {
        viewModelScope.launch {
            repository.refreshBites()
        }
    }
}
