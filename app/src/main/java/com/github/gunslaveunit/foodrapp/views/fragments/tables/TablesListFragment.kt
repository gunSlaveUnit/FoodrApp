package com.github.gunslaveunit.foodrapp.views.fragments.tables

import android.os.Bundle
import android.os.StrictMode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.gunslaveunit.foodrapp.R
import com.github.gunslaveunit.foodrapp.data.viewmodels.TableViewModel
import com.github.gunslaveunit.foodrapp.utils.database.Initializer

class TablesListFragment : Fragment() {
    private lateinit var tableViewModel: TableViewModel
    private val adapter = ListAdapter()

    override fun onStart() {
        super.onStart()
        refreshData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val view = inflater.inflate(R.layout.fragment_tables_list, container, false)

        tableViewModel = ViewModelProvider(this)[TableViewModel::class.java]

        val tablesListView = view.findViewById<RecyclerView>(R.id.tablesList)
        tablesListView.adapter = adapter
        tablesListView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    private fun refreshData() {
        val tables = tableViewModel.all()

        if (tables.isEmpty())
            prepopulateData()

        adapter.setData(tables)
    }

    private fun prepopulateData() {
        val initializer = Initializer()
        initializer.prepopulateTables(tableViewModel)
    }
}