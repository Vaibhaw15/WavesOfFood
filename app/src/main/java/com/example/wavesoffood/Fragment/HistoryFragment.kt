package com.example.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.BuyAgainAdapter
import com.example.wavesoffood.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
   private lateinit var binding : FragmentHistoryBinding
   private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setUpRecyclerView()
        binding.buyAgainFoodImage.setImageResource( R.drawable.pizza)
        return binding.root
    }
    private fun setUpRecyclerView() {
        val buyAgainFoodName = listOf("Pizza", "Burger", "Hotdog", "Pizza", "Burger", "Hotdog")
        val  buyAgainFoodPrice = listOf("$5", "$7", "$6", "$5", "$7", "$6")
        val buyAgainFoodImage = listOf(R.drawable.pizza, R.drawable.pizza, R.drawable.pizza, R.drawable.pizza, R.drawable.pizza, R.drawable.pizza)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
        binding.buyAgainRecyclerView.adapter = buyAgainAdapter
        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
    companion object {

    }
}