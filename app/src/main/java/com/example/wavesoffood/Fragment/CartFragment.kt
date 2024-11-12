package com.example.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.CartAdapter
import com.example.wavesoffood.databinding.FragmentCartBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CartFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName = listOf("Pizza", "Burger", "Hotdog")
        val cartItemPrice = listOf("$12.99", "$7.99", "$5.99")
        val cartImage = listOf(R.drawable.pizza, R.drawable.pizza, R.drawable.pizza)
        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList( cartItemPrice), ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        return binding.root

    }

    companion object {

    }
}