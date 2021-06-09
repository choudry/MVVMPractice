package com.maani.mvvmpractice.data.localdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maani.mvvmpractice.data.localdb.entities.CURRENT_USER_ID
import com.maani.mvvmpractice.data.localdb.entities.User

@Dao
interface UserDao {

    //To insert and update
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User): Long

    @Query ("SELECT * FROM User WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>
}