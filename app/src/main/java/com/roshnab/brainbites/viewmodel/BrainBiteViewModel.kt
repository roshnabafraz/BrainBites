package com.roshnab.brainbites.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roshnab.brainbites.data.Bite
import kotlinx.coroutines.launch
import android.util.Log
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.Flow

class BrainBiteViewModel(private val repository: BitesRepository) : ViewModel() {
    val bites = repository.biteDao.getAllBites()

    init {
        viewModelScope.launch {
            repository.refreshBites()
        }
    }


    fun saveBite(id : Int, isSaved : Boolean) {
        viewModelScope.launch {
            repository.saveBite(id, isSaved)
        }
    }

    fun getBitesByCategory(category: String): Flow<List<Bite>> {
        return repository.getBitesByCategory(category)
    }

}
