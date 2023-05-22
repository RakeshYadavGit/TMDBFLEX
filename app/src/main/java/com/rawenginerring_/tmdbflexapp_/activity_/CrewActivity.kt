package com.rawenginerring_.tmdbflexapp_.activity_

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore.CrewAdapterShowMore
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.databinding.ActivityCrewBinding

class CrewActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityCrewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCrewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        supportActionBar?.apply {
            setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this@CrewActivity, R.color.colorPrimary)))
        }
        mBinding.crew.adapter = CrewAdapterShowMore(MovieDetails_.movieCreditInformation)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}