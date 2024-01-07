package com.example.gymapp
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase


class EntityDB {
    @Entity(tableName = "user")
    data class User(
        @PrimaryKey val id: Long,
        val name: String,
        val email: String
    )
}


// Dao
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<EntityDB.User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: EntityDB.User)

    // Altre operazioni di accesso ai dati
}

// Database
@Database(entities = [EntityDB.User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}