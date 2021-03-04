package com.fabiocarvalho.appcommerce.models

import androidx.room.Embedded
import androidx.room.Relation

data class OrderWithOrderedProducts(
    @Embedded val order: Order,
    @Relation(
        parentColumn = "id",
        entityColumn = "orderId"
    )
    val products: MutableList<OrderedProduct> = emptyList<OrderedProduct>().toMutableList()

)
