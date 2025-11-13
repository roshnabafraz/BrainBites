package com.roshnab.brainbites.data

data class BiteDto(
    val id: Int,
    val category: String,
    val text: String,
    val isSaved : Boolean = false
)

data class BiteResponse(
    val bites: List<BiteDto>
)