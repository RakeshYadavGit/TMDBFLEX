package com.rawenginerring_.tmdbflexapp_.activity_

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rawenginerring_.tmdbflexapp_.Adapter.ViewPagerAdapter
import com.rawenginerring_.tmdbflexapp_.databinding.ActivitySearchBinding
import com.rawenginerring_.tmdbflexapp_.fragments.*

class SearchActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySearchBinding
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = Bundle()
        mBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        supportActionBar!!.hide()
        setupViewPager(bundle)
    }

    private fun setupViewPager(bundle: Bundle) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        val movieSearchFragment = MovieSearchFragment()
        adapter.addFragment(movieSearchFragment, "Movies")

        val tvShowSearchFragment = TvShowSearchFragment()
        adapter.addFragment(tvShowSearchFragment, "TV Shows")

        val peopleSearchFragment = PeopleSearchFragment()
        adapter.addFragment(peopleSearchFragment, "Peoples")


        mBinding.viewPager.adapter = adapter

        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
        mBinding.tabLayout.getTabAt(0)?.text = "Movies"
        mBinding.tabLayout.getTabAt(1)?.text = "TV Shows"
        mBinding.tabLayout.getTabAt(2)?.text = "Peoples"

    }
}