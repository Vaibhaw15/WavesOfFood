package com.example.wavesoffood.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.MenuAdapter
import com.example.wavesoffood.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        binding.buttonBack.setOnClickListener({
            dismiss()
        })
        val menuFoodName = listOf("Pizza", "Burger", "Hotdog","Pizza", "Burger", "Hotdog","Pizza", "Burger", "Hotdog")
        val menuItemPrice = listOf("$12.99", "$7.99", "$5.99","$12.99", "$7.99", "$5.99","$12.99", "$7.99", "$5.99")
        val menuImage = listOf(R.drawable.pizza, R.drawable.pizza, R.drawable.pizza,R.drawable.pizza, R.drawable.pizza, R.drawable.pizza,R.drawable.pizza, R.drawable.pizza, R.drawable.pizza)
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList( menuItemPrice), ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root

    }

    companion object {

    }
}