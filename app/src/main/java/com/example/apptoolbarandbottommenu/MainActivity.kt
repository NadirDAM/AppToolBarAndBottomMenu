package com.example.apptoolbarandbottommenu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var appBarConfig: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //BOTTOM NAVIGATION --
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNAvigationView)

        bottomNavView.setupWithNavController(navController)



        //NAVIGATION DRAWER BASIC
        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setupWithNavController(navController)





        //NAVIGATION DRAWER AMB ACTIONBAR
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        toolbar=findViewById(R.id.toolbar)



        //The given Activity will be linked to the specified DrawerLayout and
        // its Actionbar's Up button will be set to a custom drawable.
        //This drawable shows a Hamburger icon when drawer is closed and an arrow when drawer is open.
        // It animates between these two states as the drawer opens.
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.nav_open, R.string.nav_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        appBarConfig = AppBarConfiguration.Builder(R.id.primerFragment2)
            //appBarConfig = AppBarConfiguration.Builder(R.id.fragmentInici, R.id.fragmentFinal, R.id.boatFragment)
            .setDrawerLayout(drawerLayout)
            .build()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        setupActionBarWithNavController(this, navController, appBarConfig)

    }

    override fun onSupportNavigateUp(): Boolean {
        // replace navigation up button with nav drawer button when on start destination
        return NavigationUI.navigateUp(navController, appBarConfig)

    }
}
