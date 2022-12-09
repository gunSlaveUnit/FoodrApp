package com.github.gunslaveunit.foodrapp.views.fragments.dishes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.gunslaveunit.foodrapp.R
import com.github.gunslaveunit.foodrapp.data.viewmodels.DishViewModel
import com.github.gunslaveunit.foodrapp.utils.database.Initializer

class FoodListFragment : Fragment() {
    private lateinit var dishViewModel: DishViewModel
    private val adapter = ListAdapter()

    override fun onStart() {
        super.onStart()
        refreshData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_food_list, container, false)

        dishViewModel = ViewModelProvider(this)[DishViewModel::class.java]

        val dishListView = view.findViewById<RecyclerView>(R.id.foodList)
        dishListView.adapter = adapter
        dishListView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    private fun refreshData() {
        val dishes = dishViewModel.all()

        if (dishes.isEmpty())
            prepopulateData()

        adapter.setData(dishes)
    }

    private fun prepopulateData() {
        val initializer = Initializer()
        initializer.prepopulateDishes(dishViewModel)
    }
}