package com.fabiocarvalho.appcommerce.models

import java.io.Serializable

data class Order(
    val id: String,
    val time: Long,
    val status: Status,
    val method: Method,
    val user: User,
    val products: MutableList<OrderedProduct> = emptyList<OrderedProduct>().toMutableList(),
    val price: Double = products.sumByDouble { it.quantity * it.product.price }
) : Serializable {

    enum class Status (val message: String){
        PENDENT("Pendente"),
        PAID("Pago"),
        PROCESSED("Processado")
    }

    enum class Method (val message: String){
        CREDIT_CARD("Cartão de Crédito"),
        BOLETO("Boleto")
    }


}
