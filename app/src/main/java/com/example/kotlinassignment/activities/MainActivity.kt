package com.example.kotlinassignment.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinassignment.DataModel.Zone
import com.example.kotlinassignment.R
import com.example.kotlinassignment.ViewModels.AssignmentViewModel
import com.example.kotlinassignment.adapter.PerformanceAdapter
import com.example.kotlinassignment.interfaces.ItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.hasFixedSize()
        getAssignmentData()
    }

    private fun getAssignmentData() {
        val mAssignmentViewModel = ViewModelProviders.of(this@MainActivity).get(AssignmentViewModel::class.java)
        mAssignmentViewModel.getData()?.observe(this, Observer<List<Zone>> { androidList ->
            recyclerView.adapter = PerformanceAdapter(this@MainActivity, androidList as ArrayList<Zone>, object : ItemClickListener {
                override fun onItemClick(pos: Int) {
                    Toast.makeText(applicationContext, "item $pos clicked", Toast.LENGTH_LONG).show()
                }
            })
        })

    }
}