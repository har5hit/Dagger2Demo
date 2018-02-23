package com.justadeveloper96.gallery.list
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.justadeveloper96.gallery.list.db.MyData

/**
 * Created by harshith on 28/6/17.
 */
class DataAdapter(val list: MutableList<MyData>, val listener:View.OnClickListener?): RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder=
            MyViewHolder(LayoutInflater.from(parent?.context).inflate(android.R.layout.simple_list_item_2,parent,false))

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.text1?.setText(list[position].text1)
        holder?.text2?.setText(list[position].text2)

    }
    override fun getItemCount(): Int =list.count()

    class MyViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        public val text1 by lazy { itemview.findViewById(android.R.id.text1) as TextView }
        public val text2 by lazy { itemview.findViewById(android.R.id.text2) as TextView }

    }
}