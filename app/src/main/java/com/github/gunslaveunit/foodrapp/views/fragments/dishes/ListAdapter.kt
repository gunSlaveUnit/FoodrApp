package com.github.gunslaveunit.foodrapp.views.fragments.dishes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.gunslaveunit.foodrapp.R
import com.github.gunslaveunit.foodrapp.data.models.Dish

class ListAdapter: RecyclerView.Adapter<DishItemViewHolder>() {
    private var dishesList = emptyList<Dish>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishItemViewHolder {
        return DishItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.dish_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DishItemViewHolder, position: Int) {
        val item = dishesList[position]

        holder.itemView.findViewById<TextView>(R.id.dishTitle).text = item.title
        holder.itemView.findViewById<TextView>(R.id.dishPrice).text = item.price.toString()
        holder.itemView.findViewById<ImageView>(R.id.photo2).setImageBitmap(item.photo)

        holder.itemView.findViewById<ConstraintLayout>(R.id.dish_item).setOnClickListener {
            val action = FoodListFragmentDirections.actionFoodListFragmentToDetailedDishFragment(item)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dishesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dishes: List<Dish>) {
        this.dishesList = dishes
        notifyDataSetChanged()
    }
}