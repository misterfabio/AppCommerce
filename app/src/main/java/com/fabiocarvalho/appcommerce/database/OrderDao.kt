package com.fabiocarvalho.appcommerce.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fabiocarvalho.appcommerce.models.Order
import com.fabiocarvalho.appcommerce.models.OrderWithOrderedProducts

@Dao
interface OrderDao {

    @Transaction
    @Query("SELECT * FROM orders WHERE id = :orderId")
    fun loadOrderAndProductById(orderId: String) : List<OrderWithOrderedProducts>

    @Query("SELECT * FROM orders WHERE userId=:userId")
    fun loadAllOrdersByUser(userId: String) : LiveData<List<Order>>

    @Transaction
    @Query("SELECT * FROM orders WHERE id = :orderId")
    fun loadOrderAndProductByUser(orderId: String) : List<OrderWithOrderedProducts>

    @Insert
    fun insert(order: Order)

    @Insert
    fun insertAll(vararg orders: Order)

    @Update
    fun update(order : Order)

}