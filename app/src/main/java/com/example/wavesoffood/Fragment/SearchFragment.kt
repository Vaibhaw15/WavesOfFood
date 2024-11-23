package com.example.wavesoffood.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.MenuAdapter
import com.example.wavesoffood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodName = listOf("Pizza", "Burger", "Hotdog")
    private val originalMenuItemPrice = listOf("$12.99", "$7.99", "$5.99")
    private val originalMenuImage = listOf(R.drawable.pizza, R.drawable.pizza, R.drawable.pizza)
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        // Initialize the filtered lists with the original data
        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        // Set up the adapter
        adapter = MenuAdapter(
            filteredMenuFoodName,
            filteredMenuItemPrice,
            filteredMenuImage,
            requireContext()
        )
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        setUpSearchView()
        return binding.root
    }

    private fun setUpSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String?) {
        // Clear the filtered lists
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        if (!query.isNullOrEmpty()) {
            // Filter the original lists based on the query
            for (i in originalMenuFoodName.indices) {
                if (originalMenuFoodName[i].contains(query, ignoreCase = true)) {
                    filteredMenuFoodName.add(originalMenuFoodName[i])
                    filteredMenuItemPrice.add(originalMenuItemPrice[i])
                    filteredMenuImage.add(originalMenuImage[i])
                }
            }
        } else {
            // If the query is empty, show all items
            filteredMenuFoodName.addAll(originalMenuFoodName)
            filteredMenuItemPrice.addAll(originalMenuItemPrice)
            filteredMenuImage.addAll(originalMenuImage)
        }

        // Notify the adapter about data changes
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}
