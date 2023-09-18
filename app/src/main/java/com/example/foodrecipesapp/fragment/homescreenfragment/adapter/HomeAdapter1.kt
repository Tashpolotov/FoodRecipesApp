package com.example.foodrecipesapp.fragment.homescreenfragment.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.HomeModel1
import com.example.foodrecipesapp.R
import com.example.foodrecipesapp.databinding.ItemHomeBinding

class HomeAdapter1(val onClick:(HomeModel1)->Unit):ListAdapter<HomeModel1, HomeAdapter1.Home1ViewHolder>(Home1Diff()) {

    private var selectedItemPosition: Int = RecyclerView.NO_POSITION


    inner class Home1ViewHolder(private val binding:ItemHomeBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeModel1) {
            binding.tvNameFood.text = model.nameFood
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imgFood)

            val isSelected = adapterPosition == selectedItemPosition

            val backgroundColor = if (isSelected) {
                ContextCompat.getColor(binding.root.context, R.color.white)
            } else {
                ContextCompat.getColor(binding.root.context, R.color.bacround_home_edit)
            }
            val textColor = if (isSelected) {
                ContextCompat.getColor(binding.root.context, R.color.text_color_splash_activity)
            } else {
                ContextCompat.getColor(binding.root.context, R.color.white)
            }


            binding.cardView.setCardBackgroundColor(backgroundColor)
            binding.tvNameFood.setTextColor(textColor)


            itemView.setOnClickListener {
                Log.d("HomeAdapter1", "Item clicked: ${model.nameFood}")

                // Обновляем selectedItemPosition
                selectedItemPosition = adapterPosition

                // Уведомляем об изменении данных
                notifyDataSetChanged()

                onClick(model)
            }

            }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Home1ViewHolder {
        return Home1ViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Home1ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class Home1Diff:DiffUtil.ItemCallback<HomeModel1>() {
    override fun areItemsTheSame(oldItem: HomeModel1, newItem: HomeModel1): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeModel1, newItem: HomeModel1): Boolean {
        return oldItem == newItem
    }

}
