package com.roshnab.brainbites.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roshnab.brainbites.api.RetrofitInstance
import com.roshnab.brainbites.data.Bite
import kotlinx.coroutines.launch
import android.util.Log

class BrainBiteViewModel : ViewModel() {

    private val _allBites = MutableLiveData<List<Bite>>()
    val allBites: LiveData<List<Bite>> = _allBites

    private val _TechBites = MutableLiveData<List<Bite>>()
    val TechBites: LiveData<List<Bite>> = _TechBites

    private val _PsychologicalBites = MutableLiveData<List<Bite>>()
    val PsychologicalBites: LiveData<List<Bite>> = _PsychologicalBites

    private val _ScienceBites = MutableLiveData<List<Bite>>()
    val ScienceBites: LiveData<List<Bite>> = _ScienceBites

    private val _HistoryBites = MutableLiveData<List<Bite>>()
    val HistoryBites: LiveData<List<Bite>> = _HistoryBites

    private val _NatureBites = MutableLiveData<List<Bite>>()
    val NatureBites: LiveData<List<Bite>> = _NatureBites

    init {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getBites()
                _allBites.postValue(response.bites)

                _PsychologicalBites.postValue(response.bites.filter { it.category == "Psychological" })
                _TechBites.postValue(response.bites.filter { it.category == "Tech" })
                _ScienceBites.postValue(response.bites.filter { it.category == "Science" })
                _HistoryBites.postValue(response.bites.filter { it.category == "History" })
                _NatureBites.postValue(response.bites.filter { it.category == "Nature" })

            } catch (e: Exception) {
                Log.e("BrainBites", "Error fetching data", e)
            }
        }
    }
}