package com.example.minor_tbd.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert

@Dao
interface UserInfoDAO {

    @Upsert
    suspend fun insertUser(user: UserInfo)

    @Delete
    suspend fun deleteUser(user: UserInfo)

}