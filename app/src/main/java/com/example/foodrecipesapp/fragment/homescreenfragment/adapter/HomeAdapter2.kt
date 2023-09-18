package com.example.foodrecipesapp.fragment.homescreenfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.HomeModel1
import com.example.domain.model.HomeModel2
import com.example.foodrecipesapp.databinding.ItemHome2Binding
import com.example.foodrecipesapp.databinding.ItemHomeBinding

class HomeAdapter2(val onClick:(HomeModel2)-> Unit): ListAdapter<HomeModel2, HomeAdapter2.Home2ViewHolder>(Home2Diff()) {

    inner class Home2ViewHolder(private val binding: ItemHome2Binding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeModel2) {
            binding.tvNameFood.text = model.nameFood
            binding.tvKcal.text = model.kcal
            binding.tvTime.text = model.time
            binding.tvStarBall.text = model.star
            binding.btnEasy.text = model.level
            binding.btn4Steps.text = model.steps
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imgFood)
            itemView.setOnClickListener {
                onClick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Home2ViewHolder {
        return Home2ViewHolder(ItemHome2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Home2ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class Home2Diff: DiffUtil.ItemCallback<HomeModel2>() {
    override fun areItemsTheSame(oldItem: HomeModel2, newItem: HomeModel2): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HomeModel2, newItem: HomeModel2): Boolean {
        return oldItem == newItem
    }

}
