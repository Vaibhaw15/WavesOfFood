package com.example.wavesoffood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.adapter.NotificationAdapter
import com.example.wavesoffood.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotificationBottomFragment : BottomSheetDialogFragment() {
   private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false)
        val notification = listOf("Your order has been Canceled Successfully", "Order has been taken by the driver", "Congrats Your Order Placed")
        val notificationImage = listOf(R.drawable.pizza, R.drawable.pizza, R.drawable.pizza)
        val adapter = NotificationAdapter(ArrayList(notification), ArrayList(notificationImage))
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.notificationRecyclerView.adapter = adapter
        return binding.root
       }

    companion object {

    }
}