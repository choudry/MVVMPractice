package com.maani.mvvmpractice.data.localdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

// We can also specify table name manually after @Entity (tableName = "")
const val CURRENT_USER_ID = 0
@Entity
data class User (
    var id : Int? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var email_verified_at: String? = null,
    var created_at: String? = null,
    var updated_at: String? = null
        ){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}