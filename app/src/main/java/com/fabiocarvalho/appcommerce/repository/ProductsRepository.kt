package com.fabiocarvalho.appcommerce.repository

import android.app.Application
import com.fabiocarvalho.appcommerce.database.AppDatabase
import com.fabiocarvalho.appcommerce.models.Product
import com.fabiocarvalho.appcommerce.models.ProductVariants

class ProductsRepository (application: Application) {

    private val productDao = AppDatabase.getDatabase(application).productDao()

    private val productCategoryDao = AppDatabase.getDatabase(application).productCategoryDao()

    val allCategories = productCategoryDao.loadAll()

    val featuredCategories = productCategoryDao.loadAllFeatured()

    val featuredProducts = productDao.loadAllFeatured()

    fun loadProductsByCategory(categoryId: String) = productDao.loadAllByCategory(categoryId)

    fun loadProductById(productId: String) = productDao.loadProductWithVariants(productId)

}