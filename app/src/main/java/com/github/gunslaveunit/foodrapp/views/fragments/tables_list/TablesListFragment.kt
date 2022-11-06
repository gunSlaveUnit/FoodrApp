package com.github.gunslaveunit.foodrapp.views.fragments.tables_list

import ListAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.gunslaveunit.foodrapp.R
import com.github.gunslaveunit.foodrapp.models.Table

class TablesListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tables_list, container, false)

        val tables = arrayListOf<Table>()

        for (i in 0..10) {
            val table = Table(i, "Lorem ipsum", i * i)

            tables.add(table)
        }

        val adapter = ListAdapter()
        val tablesListView = view.findViewById<RecyclerView>(R.id.tablesList)
        tablesListView.adapter = adapter
        tablesListView.layoutManager = LinearLayoutManager(requireContext())

        adapter.setData(tables)

        return view
    }
}