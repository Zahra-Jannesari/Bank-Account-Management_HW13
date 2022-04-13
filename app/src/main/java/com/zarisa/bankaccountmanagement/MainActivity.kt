package com.zarisa.bankaccountmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.zarisa.bankaccountmanagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.profileFragment,
                R.id.createAccountFragment,
                R.id.showAccountsFragment,
                R.id.selectAccountFragment,
                R.id.deleteAllAccounts
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        binding.navView.setNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.deleteAllAccounts -> {
//
//                    true
//                }
//            }
//            NavigationUI.onNavDestinationSelected(it, navController)
//            drawerLayout.closeDrawer(GravityCompat.START)
//            true
//        }
    }
// I will enable menu if i needed
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.drawer_menu, menu)
//        return true
//    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}





