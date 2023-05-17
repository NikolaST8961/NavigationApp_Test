package com.example.navdrawertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navdrawertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var conf:AppBarConfiguration
    private lateinit var navController:NavController
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.ab.toolbar)
        navController = findNavController(R.id.fragmentContainerView)
        conf = AppBarConfiguration(
            setOf(
                R.id.item1,
                R.id.item2
            ), binding.drawer
        )
        setupActionBarWithNavController(navController, conf)
        binding.navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(conf) || super.onSupportNavigateUp()
    }
}