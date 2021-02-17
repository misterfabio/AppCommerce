package com.fabiocarvalho.appcommerce.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fabiocarvalho.appcommerce.R
import com.fabiocarvalho.appcommerce.models.Order
import java.text.SimpleDateFormat
import java.util.*

class OrderAdapter (val list: List<Order>, val context: Context) :
    RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id : TextView = itemView.findViewById(R.id.tv_id)
        val method : TextView = itemView.findViewById(R.id.tv_method)
        val status : TextView = itemView.findViewById(R.id.tv_status)
        val time : TextView = itemView.findViewById(R.id.tv_time)
        val price : TextView = itemView.findViewById(R.id.tv_total)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val order = list[position]
        holder.id.text = order.id
        holder.method.text = order.method.message
        holder.status.text = order.status.message
        holder.time.text = SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.getDefault()).format(Date(order.time))
        holder.price.text = order.price.toString()
    }

    override fun getItemCount(): Int = list.size

}