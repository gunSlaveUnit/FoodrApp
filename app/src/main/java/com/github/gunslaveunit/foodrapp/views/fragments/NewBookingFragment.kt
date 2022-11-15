package com.github.gunslaveunit.foodrapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.gunslaveunit.foodrapp.R

class NewBookingFragment : Fragment() {
    private val args by navArgs<NewBookingFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_booking, container, false)

        view.findViewById<Button>(R.id.cancel_new_booking_button).setOnClickListener{
            findNavController().navigate(R.id.action_newBookingFragment_to_tablesListFragment)
        }

        view.findViewById<TextView>(R.id.new_booking_table_number).text = args.table.number.toString()

        return view
    }
}