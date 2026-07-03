package com.example.androidquest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidquest.databinding.ActivityMainBinding
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> replaceFragment(HomeFragment())

                R.id.nav_members -> replaceFragment(MembersFragment())

                R.id.nav_register -> replaceFragment(RegisterFragment())

            }
            true
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    private var isDarkMode = false

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.action_theme -> {

                if (isDarkMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }

                isDarkMode = !isDarkMode
                return true
            }

            R.id.action_exit -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction()

            .replace(R.id.frameLayout, fragment)

            .commit()

    }
}