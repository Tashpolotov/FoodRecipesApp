package com.example.foodrecipesapp.fragment.infofragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.InfoStepsModel
import com.example.foodrecipesapp.databinding.ItemStepInfoBinding

class InfoAdapter:ListAdapter<InfoStepsModel, InfoAdapter.InfoViewHolder>(InfoDiff()) {


    inner class InfoViewHolder(private val binding:ItemStepInfoBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(model: InfoStepsModel) {
            binding.tvSteps.text = model.steps
            binding.tvStepsInfo.text = model.stepInfo
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        return InfoViewHolder(ItemStepInfoBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class InfoDiff:DiffUtil.ItemCallback<InfoStepsModel>() {
    override fun areItemsTheSame(oldItem: InfoStepsModel, newItem: InfoStepsModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: InfoStepsModel, newItem: InfoStepsModel): Boolean {
        return oldItem == newItem
    }

}
