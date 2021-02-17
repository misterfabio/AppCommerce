package com.fabiocarvalho.appcommerce.models

import java.io.Serializable

data class User(
    val id: String,
    val email: String,
    val nome: String,
    val surname: String,
    val password: String,
    val image: String,
    val address: List<UserAddress> = emptyList()) : Serializable