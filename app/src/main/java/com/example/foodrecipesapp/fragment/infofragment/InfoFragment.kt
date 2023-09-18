package com.example.foodrecipesapp.fragment.infofragment

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipesapp.R
import com.example.foodrecipesapp.databinding.FragmentInfoBinding
import com.example.foodrecipesapp.fragment.homescreenfragment.HomeScreenFragment
import com.example.foodrecipesapp.viewmodel.FoodViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InfoFragment : Fragment() {

    private lateinit var binding:FragmentInfoBinding
    private val adapter = InfoAdapter()
    private val viewModel by viewModels<FoodViewModel>()
    private lateinit var countDownTimer: CountDownTimer
    private var timeInSeconds = 0L


    private val slideUpAnimation by lazy {
        AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
    }

    private val slideDownAnimation by lazy {
        AnimationUtils.loadAnimation(requireContext(), R.anim.slide_down)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(inflater, container, false)
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
               val category =  it.infoStep.filter { name == it.name }
                adapter.submitList(category)
            }
        }
        viewModel.loafInfoStep()
    }

    private fun initBtn() {
        binding.imgBack.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, HomeScreenFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.nescrolledView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY > oldScrollY && binding.btnStart.visibility == View.VISIBLE) {
                binding.btnStart.startAnimation(slideDownAnimation)
                binding.btnStart.visibility = View.GONE
            } else if (scrollY < oldScrollY && binding.btnStart.visibility != View.VISIBLE) {
                binding.btnStart.startAnimation(slideUpAnimation)
                binding.btnStart.visibility = View.VISIBLE
            }
        }
    }

    private fun initGetBundle() {
        val name = arguments?.getString("name")
        val star = arguments?.getString("star")
        val kcal = arguments?.getString("kcal")
        val time = arguments?.getString("time")
        val img = arguments?.getInt("img")


        binding.tvHowCook.text = "How to cook $name"
        binding.tvNameFood.text = name
        binding.tvKcal.text = kcal
        binding.tvStar.text = star
        binding.tvTime.text = time
        binding.tvTime1.text = time
        if(img != null) {
            binding.imgFood.setImageResource(img)
        }
        val timeParts = time?.split(":")
        val minutes = timeParts?.get(0)?.toLong() ?: 0
        val seconds = timeParts?.get(1)?.toLong() ?: 0
        timeInSeconds = minutes * 60 + seconds

        // Запускаем отсчет времени
        startCountdown()
    }
    private fun startCountdown() {
        countDownTimer = object : CountDownTimer(timeInSeconds * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 60000
                val seconds = (millisUntilFinished % 60000) / 1000

                // Форматируем минуты и секунды в текст и обновляем поле
                val timeText = String.format("%02d:%02d", minutes, seconds)
                binding.tvTime1.text = timeText
            }

            override fun onFinish() {
                // Таймер завершил отсчет
                binding.tvTime1.text = "00:00"
            }
        }

        // Запускаем таймер
        countDownTimer.start()
        binding.btnStart.setOnClickListener {
            countDownTimer.cancel()
        }
    }

}