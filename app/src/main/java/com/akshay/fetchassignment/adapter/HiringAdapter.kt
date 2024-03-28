package com.akshay.fetchassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.fetchassignment.R
import com.akshay.fetchassignment.model.HiringListItem

//Adapter class that binds and sets the data to recycler view

class HiringAdapter(var items: List<HiringListItem>) : RecyclerView.Adapter<HiringAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val id = view.findViewById<TextView>(R.id.hiring_id)
        val list_id = view.findViewById<TextView>(R.id.list_id)
        val name= view.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.hiring_list_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val hriring = items[position]
        holder.id.text = "ID: ${hriring.id.toString()}"
        holder.list_id.text = "List ID: ${hriring.listId.toString()}"
        holder.name.text= "Name: ${hriring.name}"

    }

    override fun getItemCount(): Int {
        return items.size
    }

    //This functions updates the data accordingly
    fun updateHiringList(hiringList: List<HiringListItem>) {
        val filteredItems = hiringList.filter { !it.name.isNullOrBlank() }

        val groupedItems = filteredItems.groupBy { it.listId }.toSortedMap()

        val sortedItems = mutableListOf<HiringListItem>()
        for (entry in groupedItems.entries) {
            val sortedList = entry.value.sortedBy { it.name }
            sortedItems.addAll(sortedList)
        }
        items = sortedItems
        notifyDataSetChanged()
    }
}