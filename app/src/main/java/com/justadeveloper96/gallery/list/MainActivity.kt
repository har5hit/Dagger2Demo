package com.justadeveloper96.gallery.list

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.justadeveloper96.gallery.R
import com.justadeveloper96.gallery.list.db.MyData
import com.justadeveloper96.helpers.helpers.RetrofitModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class MainActivity : MyActivity(), SwipeRefreshLayout.OnRefreshListener, LifecycleRegistryOwner {
    override fun getLifecycle(): LifecycleRegistry =mRegistry

    private val mRegistry by lazy { LifecycleRegistry(this) }

    @Inject
    lateinit var retrofit: Retrofit

    override fun onRefresh() {
        netcall()
    }

    private var registry = null
    private val vm by lazy{ViewModelProviders.of(this).get(DataViewModel::class.java) as DataViewModel}
    private val rv by lazy{findViewById(R.id.recycler_view) as RecyclerView}
    private val swipe by lazy{findViewById(R.id.swipe) as SwipeRefreshLayout}

    private val list:MutableList<MyData> = ArrayList<MyData>()

    private val adapter by lazy { DataAdapter(list,null) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipe.setOnRefreshListener(this)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        rv.setLayoutManager(mLayoutManager)
        rv.setItemAnimator(DefaultItemAnimator())

        rv.adapter=adapter;

        vm.setContext(this)

        vm.getData().observe(this,object :Observer<List<MyData>>{
            override fun onChanged(t: List<MyData>?) {
                list.clear()
                list.addAll(t!!)
                adapter.notifyDataSetChanged()
            }
        })
    }


    fun netcall() {

        retrofit.create(RetrofitService::class.java).getData().enqueue(object : Callback<List<MyData>> {
            override fun onFailure(call: Call<List<MyData>>?, t: Throwable?) {
                t?.printStackTrace()
                swipe.isRefreshing = false
            }

            override fun onResponse(call: Call<List<MyData>>?, response: Response<List<MyData>>?) {
                swipe.isRefreshing = false
                if (response!!.isSuccessful) {
                    vm.saveData(response.body()!!)
                }
            }
        }
        )
    }
}
