package com.roshnab.brainbites.viewmodel

import android.util.Log
import com.roshnab.brainbites.api.apiservice
import com.roshnab.brainbites.data.Bite
import com.roshnab.brainbites.database.Bite_DAO

class BitesRepository(val biteDao: Bite_DAO, val api: apiservice) {
    suspend fun refreshBites() {
        try {
            val response = api.getBites() // returns BiteResponse
            val biteList = response.bites.map { dto ->
                Bite(
                    id = dto.id,
                    category = dto.category,
                    text = dto.text,
                    isSaved = dto.isSaved
                )
            }
            biteDao.insertAll(biteList)
        } catch (e: Exception) {
            Log.e("BitesRepository", "Error refreshing bites: ${e.message}")
        }
    }
}
