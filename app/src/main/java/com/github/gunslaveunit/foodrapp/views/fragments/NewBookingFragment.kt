package com.github.gunslaveunit.foodrapp.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.gunslaveunit.foodrapp.R
import com.github.gunslaveunit.foodrapp.data.models.Booking
import com.github.gunslaveunit.foodrapp.data.viewmodels.BookingViewModel

class NewBookingFragment : Fragment() {
    private val args by navArgs<NewBookingFragmentArgs>()
    private lateinit var bookingViewModel: BookingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_booking, container, false)

        bookingViewModel = ViewModelProvider(this)[BookingViewModel::class.java]

        view.findViewById<Button>(R.id.cancel_new_booking_button).setOnClickListener{
            findNavController().navigate(R.id.action_newBookingFragment_to_tablesListFragment)
        }

        view.findViewById<Button>(R.id.new_booking_confirm_button).setOnClickListener{
            findNavController().navigate(R.id.action_newBookingFragment_to_tablesListFragment)
        }

        view.findViewById<TextView>(R.id.new_booking_table_number).text = args.table.number.toString()

        view.findViewById<Button>(R.id.new_booking_confirm_button).setOnClickListener {
            makeBooking()
        }

        return view
    }

    private fun makeBooking() {
        val guestNameField = view?.findViewById<TextView>(R.id.new_booking_client_name)
        val guestPhoneField = view?.findViewById<TextView>(R.id.new_booking_client_phone)
        val dateField = view?.findViewById<TextView>(R.id.new_booking_date)
        val startTimeField = view?.findViewById<TextView>(R.id.new_booking_time_start)
        val endTimeField = view?.findViewById<TextView>(R.id.new_booking_time_end)

        val guestName = guestNameField?.text.toString()
        val guestPhone = guestPhoneField?.text.toString()
        val startDateTime = dateField?.text.toString().plus(" ").plus(startTimeField?.text.toString())
        val endDateTime = dateField?.text.toString().plus(" ").plus(endTimeField?.text.toString())

        val booking = Booking(0, args.table.number, guestName, guestPhone, startDateTime, endDateTime)

        Log.d("Boo", guestPhone)

        bookingViewModel.make(booking)
    }
}