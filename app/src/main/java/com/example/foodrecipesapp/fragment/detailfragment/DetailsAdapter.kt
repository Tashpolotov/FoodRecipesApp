package com.example.foodrecipesapp.fragment.detailfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.DetailsIngredientModel
import com.example.foodrecipesapp.databinding.ItemDetailsBinding

class DetailsAdapter:ListAdapter<DetailsIngredientModel, DetailsAdapter.DetailsViewHolder>(DetailsDiff()) {

    inner class DetailsViewHolder(private val binding:ItemDetailsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: DetailsIngredientModel) {
            binding.tvNameIngredientFood.text = model.nameIngredientFood
            binding.tvGram.text = model.gram
            Glide.with(binding.root)
                .load(model.img)
                .into(binding.imgIngredientFood)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(ItemDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DetailsDiff:DiffUtil.ItemCallback<DetailsIngredientModel>() {
    override fun areItemsTheSame(
        oldItem: DetailsIngredientModel,
        newItem: DetailsIngredientModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: DetailsIngredientModel,
        newItem: DetailsIngredientModel
    ): Boolean {
        return oldItem == newItem
    }

}
