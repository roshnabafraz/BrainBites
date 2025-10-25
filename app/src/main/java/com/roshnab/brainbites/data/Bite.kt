package com.roshnab.brainbites.data

data class Bite(
    val category: String,
    val text: String
)

data class BiteResponse(
    val bites: List<Bite>
)