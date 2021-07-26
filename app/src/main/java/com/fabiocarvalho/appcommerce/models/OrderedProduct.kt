package com.fabiocarvalho.appcommerce.models

import androidx.room.Embedded
import androidx.room.Entity
import java.io.Serializable
import java.util.*

@Entity(tableName = "ordered_products", primaryKeys = ["orderedProductId", "orderId"])
data class OrderedProduct(
    var orderedProductId: String = UUID.randomUUID().toString(),
    var orderId: String,
    @Embedded val product: Product,
    var size: String = "",
    var color: String = "",
    var quantity: Int = 0) : Serializable