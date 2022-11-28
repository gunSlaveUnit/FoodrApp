package com.github.gunslaveunit.foodrapp.views.fragments.bookings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.gunslaveunit.foodrapp.R
import com.github.gunslaveunit.foodrapp.data.viewmodels.BookingViewModel

class ClientReservationsFragment : Fragment() {
    private lateinit var bookingViewModel: BookingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_client_reservations, container, false)

        bookingViewModel = ViewModelProvider(this)[BookingViewModel::class.java]

        val adapter = ListAdapter()
        val bookingsListView = view.findViewById<RecyclerView>(R.id.bookingsList)
        bookingsListView.adapter = adapter
        bookingsListView.layoutManager = LinearLayoutManager(requireContext())

        bookingViewModel.all().observe(viewLifecycleOwner) { bookings ->
            adapter.setData(bookings)
        }

        return view
    }
}