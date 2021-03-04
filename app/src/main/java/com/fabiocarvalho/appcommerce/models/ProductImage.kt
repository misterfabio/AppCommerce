package com.fabiocarvalho.appcommerce.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "product_images")
data class ProductImage(
    @PrimaryKey val id:String = UUID.randomUUID().toString(),
    var productId:String,
    var path:String): Serializable
