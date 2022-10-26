package com.github.gunslaveunit.foodrapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.github.gunslaveunit.foodrapp.R

class TablesListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tables_list, container, false)

        val tablesLayout = view.findViewById<LinearLayout>(R.id.tablesList)
        for (i in 0..10) {
            val table = inflater.inflate(R.layout.table_list_item, container, false)

            val image = table.findViewById<ImageView>(R.id.photo)
            image.setImageResource(R.color.purple_500)

            val number = table.findViewById<TextView>(R.id.number)
            number.text = i.toString()

            val description = table.findViewById<TextView>(R.id.description)
            description.text = "Lorem ipsum"

            val capacity = table.findViewById<TextView>(R.id.capacity)
            capacity.text = (i * i).toString();

            tablesLayout.addView(table)
        }

        return view
    }
}