package com.github.gunslaveunit.foodrapp.views.fragments.tables

import ListAdapter
import android.graphics.BitmapFactory
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
import com.github.gunslaveunit.foodrapp.data.models.Table
import com.github.gunslaveunit.foodrapp.data.viewmodels.TableViewModel
import com.github.gunslaveunit.foodrapp.utils.database.Initializer
import java.net.URL

class TablesListFragment : Fragment() {
    private lateinit var tableViewModel: TableViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val view = inflater.inflate(R.layout.fragment_tables_list, container, false)

        tableViewModel = ViewModelProvider(this)[TableViewModel::class.java]

        tableViewModel.all().observe(viewLifecycleOwner) { tables ->
            if (tables.isEmpty())
                prepopulateData()
        }

        val adapter = ListAdapter()
        val tablesListView = view.findViewById<RecyclerView>(R.id.tablesList)
        tablesListView.adapter = adapter
        tablesListView.layoutManager = LinearLayoutManager(requireContext())

        tableViewModel.all().observe(viewLifecycleOwner) { tables ->
            adapter.setData(tables)
        }

        return view
    }

    private fun prepopulateData() {
        val initializer = Initializer()
        initializer.prepopulateTables(tableViewModel)
    }
}