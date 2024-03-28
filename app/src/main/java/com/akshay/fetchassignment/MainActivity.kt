package com.akshay.fetchassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.fetchassignment.adapter.HiringAdapter
import com.akshay.fetchassignment.viewmodel.HiringViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: HiringViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recView: RecyclerView = findViewById(R.id.recycler)
        recView.layoutManager = LinearLayoutManager(this)

        val adapter = HiringAdapter(emptyList())
        recView.adapter = adapter

        viewModel = ViewModelProvider(this).get(HiringViewModel::class.java)

        viewModel.getHiringDetails()

        //Observes the data changes and notifies the UI changes.

        viewModel.data.observe(this, { item ->
            adapter.apply {
                item.let {
                    updateHiringList(it)
                }
            }

        })


    }
}