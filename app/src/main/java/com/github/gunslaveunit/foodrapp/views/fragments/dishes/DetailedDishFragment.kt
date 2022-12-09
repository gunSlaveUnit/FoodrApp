package com.github.gunslaveunit.foodrapp.views.fragments.dishes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.github.gunslaveunit.foodrapp.R

class DetailedDishFragment : Fragment() {
    private val args by navArgs<DetailedDishFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detailed_dish, container, false)

        view.findViewById<TextView>(R.id.dishDetailedTitle).text = args.dish.title

        return view
    }
}