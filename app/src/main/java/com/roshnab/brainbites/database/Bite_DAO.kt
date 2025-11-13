package com.roshnab.brainbites.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.roshnab.brainbites.data.Bite
import kotlinx.coroutines.flow.Flow

@Dao
interface Bite_DAO {

    @Query("SELECT * FROM Bite")
    fun getAllBites(): Flow<List<Bite>>

    @Query("SELECT * FROM Bite WHERE Bite.isSaved = TRUE")
    fun SavedBites(): Flow<List<Bite>>

    @Query("SELECT * FROM Bite WHERE Bite.category = :category")
    fun CategoryBites(category: String): Flow<List<Bite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(bites: List<Bite>)

    @Query("SELECT * FROM Bite WHERE Bite.id = :id")
    fun showBite(id: Int): Flow<Bite>
}
