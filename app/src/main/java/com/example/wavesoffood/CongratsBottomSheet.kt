package com.example.wavesoffood

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import com.example.wavesoffood.databinding.FragmentCongratsBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment



class CongratsBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentCongratsBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCongratsBottomSheetBinding.inflate(inflater, container, false)
        binding.goHomeButton.setOnClickListener({
            val intent  = Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)
        })
        return binding.root
    }

    companion object {

    }
}