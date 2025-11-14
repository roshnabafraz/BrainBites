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

    @Query("SELECT * FROM Bite WHERE Bite.category = :category")
    fun getBitesByCategory(category : String): Flow<List<Bite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(bites: List<Bite>)

    @Query("UPDATE Bite SET isSaved = :isSaved WHERE Bite.id = :id")
    suspend fun saveBite(id: Int, isSaved: Boolean)
}
