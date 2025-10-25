package com.roshnab.brainbites.api

import com.roshnab.brainbites.data.Bite
import com.roshnab.brainbites.data.BiteResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface apiservice {

    @GET("b/68e2717bae596e708f06d6cc?meta=false")
    suspend fun getBites(): BiteResponse
//
//    @GET("b/68e2717bae596e708f06d6cc?meta=false")
//    @Headers("X-JSON-Path: bites[?(@.category==\"Tech\")]")
//    suspend fun getTechBites(): BiteResponse
}