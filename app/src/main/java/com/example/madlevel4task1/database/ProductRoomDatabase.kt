package com.example.madlevel4task1.database;

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.madlevel4task1.dao.ProductDao
import com.example.madlevel4task1.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductRoomDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        private const val DATABASE_NAME = "SHOPPING_LIST_DATABASE"

        @Volatile
        private var roomDatabaseInstance: ProductRoomDatabase? = null

        fun getDatabase(context: Context): ProductRoomDatabase? {
            if (roomDatabaseInstance == null) {
                synchronized(ProductRoomDatabase::class.java) {
                    if (roomDatabaseInstance == null) {
                        roomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            ProductRoomDatabase::class.java,
                            DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return roomDatabaseInstance
        }
    }

}