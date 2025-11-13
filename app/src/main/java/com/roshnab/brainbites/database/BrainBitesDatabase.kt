package com.roshnab.brainbites.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.roshnab.brainbites.data.Bite

@Database(entities = [Bite::class], version = 1)
abstract class BrainBitesDatabase : RoomDatabase() {

    abstract fun biteDao(): Bite_DAO

    companion object {
        @Volatile
        private var INSTANCE: BrainBitesDatabase? = null

        fun getDatabase(context: Context): BrainBitesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BrainBitesDatabase::class.java,
                    "brain_bites_db").build()
                INSTANCE = instance
                instance
            }
        }
    }
}