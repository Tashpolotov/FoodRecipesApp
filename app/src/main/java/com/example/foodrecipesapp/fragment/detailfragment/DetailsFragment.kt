package com.example.foodrecipesapp.fragment.detailfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.DetailsIngredientModel
import com.example.foodrecipesapp.R
import com.example.foodrecipesapp.databinding.FragmentDetailsBinding
import com.example.foodrecipesapp.fragment.infofragment.InfoFragment
import com.example.foodrecipesapp.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding:FragmentDetailsBinding
    private val adapter = DetailsAdapter()
    private val viewModel by viewModels<FoodViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGetBundle()
        initBtn()
        initAdapter()
    }

    private fun initAdapter() {
        val name = arguments?.getString("name")
        binding.rv2.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.food.collect{
                val category = it.detailsFood.filter { name == it.nameFood }
                adapter.submitList(category)
            }
        }
        viewModel.loadDetails()
    }

    private fun initGetBundle() {
        val name = arguments?.getString("name")
        val star = arguments?.getString("star")
        val kcal = arguments?.getString("kcal")
        val time = arguments?.getString("time")
        val img = arguments?.getInt("img")


        binding.tvNameFood.text = name
        binding.tvKcal.text = kcal
        binding.tvStar.text = star
        binding.tvTime.text = time.toString()
        if(img != null) {
            binding.imgFood.setImageResource(img)
        }

    }
    private fun initBtn(){
        binding.imgBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        binding.btnStart.setOnClickListener {
            val name = arguments?.getString("name")
            val star = arguments?.getString("star")
            val kcal = arguments?.getString("kcal")
            val time = arguments?.getString("time")
            val img = arguments?.getInt("img")

            val fragment = InfoFragment()
            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("star", star)
            bundle.putString("kcal", kcal)
            bundle.putString("time", time)
            img?.let { it1 -> bundle.putInt("img", it1) }
            fragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

}