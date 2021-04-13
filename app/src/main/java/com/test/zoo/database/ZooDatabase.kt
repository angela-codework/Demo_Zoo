package com.test.zoo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Create database from assets.
 */
@Database(entities = [ZooInfo::class, Plant::class], exportSchema = true, version = 1)
abstract class ZooDatabase: RoomDatabase() {

    abstract fun zooDao(): ZooDao

    companion object {
        private const val DB_NAME = "zoo.db"

        private var instance: ZooDatabase? = null

        @Synchronized
        fun getInstance(context: Context): ZooDatabase {
            if (instance == null) {
                instance = create(context)
            }
            return instance!!
        }

        private fun create(context: Context): ZooDatabase? {
            //get zoo db from assets
            return Room.databaseBuilder(context, ZooDatabase::class.java, DB_NAME)
                .createFromAsset("database/$DB_NAME")
                .build()
        }
    }

}