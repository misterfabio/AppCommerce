package com.fabiocarvalho.appcommerce.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fabiocarvalho.appcommerce.repository.ProductsRepository

class ProductViewModel (application: Application) : AndroidViewModel(application){

    private val productsRepository = ProductsRepository(getApplication())

    val allCategories = productsRepository.allCategories()

    val featuredCategories = productsRepository.featuredCategories()

    val featuredProducts = productsRepository.featuredProducts()

    fun getProductsByCategory(categoryId: String) = productsRepository.loadProductsByCategory(categoryId)

    fun getProductWithVariants(productId: String) = productsRepository.loadProductById(productId)


}