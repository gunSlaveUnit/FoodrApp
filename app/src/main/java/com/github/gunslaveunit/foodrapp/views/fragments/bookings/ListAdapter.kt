package com.github.gunslaveunit.foodrapp.views.fragments.bookings

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.gunslaveunit.foodrapp.R
import com.github.gunslaveunit.foodrapp.data.models.Booking
import com.github.gunslaveunit.foodrapp.views.fragments.tables.TableItemViewHolder

class ListAdapter : RecyclerView.Adapter<TableItemViewHolder>() {
    private var bookingsList = emptyList<Booking>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableItemViewHolder {
        return TableItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.booking_client_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TableItemViewHolder, position: Int) {
        val item = bookingsList[position]

        holder.itemView.findViewById<TextView>(R.id.tableNumber).text = item.tableId.toString()
        holder.itemView.findViewById<TextView>(R.id.clientName).text = item.guestName
        holder.itemView.findViewById<TextView>(R.id.bookingStartTime).text = item.startTime
        holder.itemView.findViewById<TextView>(R.id.bookingEndTime).text = item.endTime
        holder.itemView.findViewById<TextView>(R.id.phone).text = item.contactPhone
    }

    override fun getItemCount(): Int {
        return bookingsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(bookings: List<Booking>) {
        this.bookingsList = bookings
        notifyDataSetChanged()
    }
}