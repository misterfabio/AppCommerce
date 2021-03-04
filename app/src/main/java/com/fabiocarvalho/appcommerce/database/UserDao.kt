package com.fabiocarvalho.appcommerce.database

import androidx.room.*
import com.fabiocarvalho.appcommerce.models.User
import com.fabiocarvalho.appcommerce.models.UserAddress
import com.fabiocarvalho.appcommerce.models.UserWithAddresses

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE id = :userId")
    fun loadUserById(userId: String):User

    @Transaction
    @Query("SELECT * FROM users WHERE id = :userId")
    fun loadUserWithAddresses(userId: String) : UserWithAddresses

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Insert
    fun insert(userAddress: UserAddress)

    @Update
    fun update(userAddress: UserAddress)

}