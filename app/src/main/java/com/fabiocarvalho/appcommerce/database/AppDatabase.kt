package com.fabiocarvalho.appcommerce.database

import android.app.Application
import androidx.room.*
import com.fabiocarvalho.appcommerce.models.*

@Database(entities = [  Order::class,
                        OrderedProduct::class,
                        Product::class,
                        ProductCategory::class,
                        ProductColor::class,
                        ProductImage::class,
                        ProductSize::class,
                        User::class,
                        UserAddress::class] , version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao
    abstract fun productDao() : ProductDao
    abstract fun productCategoryDao() : ProductCategoryDao
    abstract fun orderDao() : OrderDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Application) : AppDatabase{
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appcomerce_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .createFromAsset("appcommerce_database.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

//[ fim ]
}