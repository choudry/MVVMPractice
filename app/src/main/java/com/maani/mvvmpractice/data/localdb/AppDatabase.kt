package com.maani.mvvmpractice.data.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maani.mvvmpractice.data.localdb.entities.User

@Database (entities = [User::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    //WE have to create a function for each DAO. As we have just one DAO (UserDao), so we create just one abstract fun
    abstract fun getUserDao() : UserDao


    companion object{

        //Voltaile means this variable will be immediately visible to all the threads
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any() //to avoid creating two instances of databases

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"MyDatabase.db").build()
    }
}