package com.fabiocarvalho.appcommerce.repository

import android.app.Application
import com.fabiocarvalho.appcommerce.database.AppDatabase

class OrdersRepository (application: Application) {

    private val orderDao = AppDatabase.getDatabase(application).orderDao()

    fun loadAllByUser(userId: String) = orderDao.loadAllOrdersByUser(userId)

}