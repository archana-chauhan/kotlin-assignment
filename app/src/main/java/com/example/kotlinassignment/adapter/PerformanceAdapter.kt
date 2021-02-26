package com.example.kotlinassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinassignment.DataModel.Zone
import com.example.kotlinassignment.R
import com.example.kotlinassignment.activities.MainActivity
import com.example.kotlinassignment.interfaces.ItemClickListener
import com.jakewharton.rxbinding.view.RxView
import kotlinx.android.synthetic.main.layout_performance.view.*

class PerformanceAdapter(var context: MainActivity, var performanceList: ArrayList<Zone>, private val itemClick: ItemClickListener): RecyclerView.Adapter<PerformanceAdapter.PerformanceHolder>()  {
    companion object {
        var mItemClickListener : ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerformanceHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_performance, parent, false)
        return PerformanceHolder(view)
    }

    override fun getItemCount(): Int {
        return performanceList.size
    }

    override fun onBindViewHolder(holder:PerformanceHolder, position: Int) {
        mItemClickListener = itemClick
        holder.tvFname?.text = performanceList[position].zone

        RxView.clicks(holder.mView).subscribe {
            mItemClickListener!!.onItemClick(position)
        }
    }

    class PerformanceHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvFname = view.tvName
        val mView = view
    }

}