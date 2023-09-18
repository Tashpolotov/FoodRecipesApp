package com.example.foodrecipesapp.fragment.homescreenfragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.transition.Fade
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.example.domain.model.HomeModel1
import com.example.domain.model.HomeModel2
import com.example.foodrecipesapp.R
import com.example.foodrecipesapp.databinding.FragmentHomeScreenBinding
import com.example.foodrecipesapp.fragment.detailfragment.DetailsFragment
import com.example.foodrecipesapp.fragment.homescreenfragment.adapter.HomeAdapter1
import com.example.foodrecipesapp.fragment.homescreenfragment.adapter.HomeAdapter2
import com.example.foodrecipesapp.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreenFragment : Fragment() {

    private lateinit var binding:FragmentHomeScreenBinding
    private val viewModel by viewModels<FoodViewModel>()
    private val adapter = HomeAdapter1(this::OnClick1)
    private val adapter2 = HomeAdapter2(this::onClick2)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initSearch()
    }

    private fun initSearch() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Ничего не делаем перед изменением текста
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Ничего не делаем при изменении текста
            }

            override fun afterTextChanged(s: Editable?) {
                // Проверяем, является ли текст пустым
                if (s.isNullOrEmpty()) {
                    // Текстовое поле пустое, восстанавливаем все заметки
                    viewModel.loadHome1()
                    viewModel.loadHome2()
                    Log.d("MyApp", "Поиск: Пустой запрос, загрузка всех элементов")
                } else {
                    // Текст введен, выполняем поиск
                    viewModel.search(query = s.toString())
                    Log.d("MyApp", "Поиск: Запрос - ${s.toString()}")
                }
            }
        })
    }

    private fun initAdapter() {
        binding.rv1.adapter = adapter
        binding.rv2.adapter = adapter2
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.food.collect{
                adapter.submitList(it.home1)

            }
        }
        viewModel.loadHome1()

    }

    private fun changeAnim(): Transition {
        val transition = Fade()
        transition.duration = 1000
        return transition
    }
    private fun onClick2(model: HomeModel2) {
       val fragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", model.nameFood)
        bundle.putInt("img", model.img)
        bundle.putString("star", model.star)
        bundle.putString("kcal", model.kcal)
        bundle.putString("time", model.time)
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun OnClick1(model:HomeModel1) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.food.collect{
                val category = it.home2.filter { model.id == it.id }
                TransitionManager.beginDelayedTransition(binding.rv2, changeAnim())

                adapter2.submitList(category)
            }
        }
        viewModel.loadHome2()
    }
}
