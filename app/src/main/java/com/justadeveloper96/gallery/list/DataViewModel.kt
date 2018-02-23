package com.justadeveloper96.gallery.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.os.AsyncTask
import com.justadeveloper96.gallery.list.db.AppDatabase
import com.justadeveloper96.gallery.list.db.MyData

/**
 * Created by harshith on 10/7/17.
 */
class DataViewModel: ViewModel() {

    private lateinit var mydb: AppDatabase

    fun setContext(context: Context){
        mydb= AppDatabase.getDatabase(context)
    }

    fun getData():LiveData<List<MyData>>
    {
        return mydb.MyDataModel().all
    }

    fun saveData(data:List<MyData>)
    {
        InsertTask(mydb).execute(data)
    }


    override fun onCleared() {
        super.onCleared()
    }

    class InsertTask(mydb:AppDatabase): AsyncTask<List<MyData>, Void, Void>()
    {
        private var database:AppDatabase


        init {
            database=mydb
        }

        override fun doInBackground(vararg params: List<MyData>): Void? {
            database.MyDataModel().destroy()
            database.MyDataModel().insertAll(params[0])
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }
    }
}