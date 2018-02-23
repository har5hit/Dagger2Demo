package com.justadeveloper96.gallery.list.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


/**
 * Created by harshith on 30/6/17.
 */
@Database(entities = arrayOf(MyData::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE==null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase::class.java, "my_db")
                        .build()

            }
            return INSTANCE!!
        }
    }

    abstract fun MyDataModel(): MyDataDao
}