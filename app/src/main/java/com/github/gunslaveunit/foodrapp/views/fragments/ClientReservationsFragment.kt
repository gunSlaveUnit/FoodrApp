package com.github.gunslaveunit.foodrapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.github.gunslaveunit.foodrapp.R

class ClientReservationsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_client_reservations, container, false)

        val tablesLayout = view.findViewById<LinearLayout>(R.id.bookingsList)
        for (i in 1..2) {
            val booking = inflater.inflate(R.layout.booking_client_list_item, container, false)

            val tableNumber = booking.findViewById<TextView>(R.id.tableNumber)
            tableNumber.text = i.toString()

            val name = booking.findViewById<TextView>(R.id.clientName)
            name.text = "Александр"

            val date = booking.findViewById<TextView>(R.id.bookingDate)
            date.text = (25 + i).toString() + ".11.2022"

            val time = booking.findViewById<TextView>(R.id.bookingTime)
            time.text = (18 + i).toString() + (15 * i).toString()

            val phone = booking.findViewById<TextView>(R.id.phone)
            phone.text = "*6548"

            tablesLayout.addView(booking)
        }

        return view
    }
}