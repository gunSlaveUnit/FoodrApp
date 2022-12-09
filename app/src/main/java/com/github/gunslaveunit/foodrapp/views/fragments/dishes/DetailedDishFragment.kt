package com.github.gunslaveunit.foodrapp.views.fragments.dishes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

        val mappedDish = args.dish

        view.findViewById<TextView>(R.id.dishDetailedTitle).text = mappedDish.title
        view.findViewById<TextView>(R.id.dishDetailedDescription).text = mappedDish.description
        view.findViewById<TextView>(R.id.dishDetailedCalories).text = mappedDish.calories.toString()
        view.findViewById<TextView>(R.id.dishDetailedComposition).text = mappedDish.composition
        view.findViewById<TextView>(R.id.dishDetailedPortion).text = mappedDish.portion.toString()
        view.findViewById<TextView>(R.id.dishDetailedPrice).text = mappedDish.price.toString()
        view.findViewById<ImageView>(R.id.dishDetailedPhoto).setImageBitmap(mappedDish.photo)


        return view
    }
}