package com.fabiocarvalho.appcommerce.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fabiocarvalho.appcommerce.repository.OrdersRepository

class OrderViewModel (application: Application) : AndroidViewModel(application) {

    private val ordersRepository = OrdersRepository(getApplication())

    fun getOrdersByUser(userId: String) = ordersRepository.loadAllByUser(userId)

}