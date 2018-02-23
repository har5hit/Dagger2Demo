package com.justadeveloper96.gallery.list.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


/**
 * Created by harshith on 28/6/17.
 */
@Dao
interface MyDataDao {
    @get:Query("SELECT * FROM MyData")
    val all: LiveData<List<MyData>>

    @Query("SELECT * FROM MyData WHERE id LIKE :arg0")
    fun find(search: Int): MyData

    @Insert
    fun insertAll(users: List<MyData>)

    @Delete
    fun delete(data: MyData)

    @Query("DELETE FROM MyData")
    fun destroy()
}