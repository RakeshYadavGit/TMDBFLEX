package com.rawenginerring_.tmdbflexapp_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.rawenginerring_.tmdbflexapp_.databinding.ActivityMainBinding
import com.rawenginerring_.tmdbflexapp_.fragments.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()
        replace(HomeFragment(),"home")
        initBottomNavigation()
    }
    private fun initBottomNavigation() {
        mainBinding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    replace(HomeFragment(),"home")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.search -> {
                    replace(SearchFragment(),"search")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.featured_lists -> {
                    replace(UserProfileFragment(),"userProfile")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bookmark -> {
                    replace(BookmarkFragment(),"bookmark")
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }

            }
        }
    }



    fun replace(fragment: Fragment?, backstack : String) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.addToBackStack(backstack)
        ft.replace(R.id.frameLayout, fragment!!)
        ft.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}