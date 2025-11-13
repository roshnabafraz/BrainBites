package com.roshnab.brainbites.api

import com.roshnab.brainbites.data.BiteDto
import com.roshnab.brainbites.data.BiteResponse
import retrofit2.http.GET

interface apiservice {
    @GET("b/68e2717bae596e708f06d6cc?meta=false")
    suspend fun getBites(): BiteResponse
}