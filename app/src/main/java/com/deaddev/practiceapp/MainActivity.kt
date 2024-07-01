package com.deaddev.practiceapp

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.deaddev.practiceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller =
            (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController

        controller?.let { navController ->
            binding?.bottomNavigation?.setupWithNavController(navController)
        }
        onBackPressedDispatcher.addCallback {
            controller?.navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}