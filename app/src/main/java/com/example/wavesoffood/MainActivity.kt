package com.example.wavesoffood

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wavesoffood.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        val navController: NavController = findNavController(R.id.fragmentContainerView)
        val bottomNav: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView3)
        bottomNav.setupWithNavController(navController)
        binding.NotificationBotton.setOnClickListener({
            val bottomSheet = NotificationBottomFragment()
            bottomSheet.show(supportFragmentManager, "Test")
        })
    }
}