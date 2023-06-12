package com.rawenginerring_.tmdbflexapp_.activity_

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.rawenginerring_.tmdbflexapp_.Adapter.ImagePagerAdapter
import com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore.SelectedMovieSliderAdapter
import com.rawenginerring_.tmdbflexapp_.Adapter.ViewPagerAdapter
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.databinding.ActivityDetailsBinding
import com.rawenginerring_.tmdbflexapp_.fragments.CastFragment
import com.rawenginerring_.tmdbflexapp_.fragments.InfoFragment
import com.rawenginerring_.tmdbflexapp_.fragments.ReviewFragment
import com.rawenginerring_.tmdbflexapp_.fragments.SimilarFragment

class DetailsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityDetailsBinding
    private var isTvShow:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val bundle = Bundle()
        supportActionBar?.apply {
            setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this@DetailsActivity, R.color.colorPrimary)))
        }


        val isTvShow = intent.getStringExtra("TV")
        bundle.putString("TV",isTvShow)

        mBinding?.viewPagerDetails?.adapter = SelectedMovieSliderAdapter(MovieDetails_.movieInformation)

        if(isTvShow=="TV"){
            mBinding.sliderText.text = MovieDetails_.movieInformation.name_
        }
        else{
            mBinding.sliderText.text = MovieDetails_.movieInformation.title
        }


        setupViewPager(bundle)


    }

    private fun setupViewPager(bundle: Bundle) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        val infoFragment = InfoFragment()
        infoFragment.arguments = bundle
        adapter.addFragment(infoFragment, "Info")

        val castFragment = CastFragment()
        adapter.addFragment(castFragment, "Cast")

        val reviewFragment = ReviewFragment()
        adapter.addFragment(reviewFragment, "Reviews")

        val similarFragment = SimilarFragment()
        similarFragment.arguments = bundle
        adapter.addFragment(similarFragment, "Similar")

        mBinding.viewPager.adapter = adapter

        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
        mBinding.tabLayout.getTabAt(0)?.text = "Info"
        mBinding.tabLayout.getTabAt(1)?.text = "Cast"
        mBinding.tabLayout.getTabAt(2)?.text = "Review"
        mBinding.tabLayout.getTabAt(3)?.text = "Similar"
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}