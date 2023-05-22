package com.rawenginerring_.tmdbflexapp_.fragments

import ReviewAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentReviewBinding


class ReviewFragment : Fragment() {
   private lateinit var mBinding: FragmentReviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentReviewBinding.inflate(inflater,container,false)
        mBinding.review.adapter = ReviewAdapter(MovieDetails_.movieRevieInformation)
        mBinding?.loader?.visibility = View.GONE
        return mBinding.root
    }
}