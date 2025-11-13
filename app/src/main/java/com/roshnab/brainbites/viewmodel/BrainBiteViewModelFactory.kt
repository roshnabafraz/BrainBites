package com.roshnab.brainbites.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roshnab.brainbites.api.RetrofitInstance
import com.roshnab.brainbites.database.BrainBitesDatabase

class BrainBiteViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val db = BrainBitesDatabase.getDatabase(context)
        val repository = BitesRepository(db.biteDao(), RetrofitInstance.api)

        if (modelClass.isAssignableFrom(BrainBiteViewModel::class.java)) {
            return BrainBiteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}