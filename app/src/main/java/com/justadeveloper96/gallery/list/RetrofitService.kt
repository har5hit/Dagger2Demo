package com.justadeveloper96.gallery.list
import com.justadeveloper96.gallery.list.db.MyData
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by sankalp on 28/6/17.
 */

interface RetrofitService {

    @GET("test")
    fun getData(): Call<List<MyData>>
}
