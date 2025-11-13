 package com.roshnab.brainbites.data

 import androidx.room.Entity
 import androidx.room.PrimaryKey

 @Entity
data class Bite(
     @PrimaryKey
     val id: Int,
    val category: String,
    val text: String,
    val isSaved : Boolean = false
)