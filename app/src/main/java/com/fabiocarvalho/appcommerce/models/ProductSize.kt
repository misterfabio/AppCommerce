package com.fabiocarvalho.appcommerce.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "product_sizes")
data class ProductSize(
    @PrimaryKey val id:String = UUID.randomUUID().toString(),
    var productId: String,
    var size:String,
    @Ignore var checked: Boolean = false) : Serializable
    {
        constructor(id: String,
                    productId: String,
                    size: String) : this(id, productId, size, false)
    }
