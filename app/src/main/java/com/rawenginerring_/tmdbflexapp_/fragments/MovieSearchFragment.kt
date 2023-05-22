package com.rawenginerring_.tmdbflexapp_.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore.SearchMovieAdapter
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentMovieSearchBinding

class MovieSearchFragment : Fragment() {

    private lateinit var mBinding: FragmentMovieSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMovieSearchBinding.inflate(inflater,container,false)
        mBinding.movieSearchFragment.adapter = SearchMovieAdapter(MovieDetails_.searchMovie,"No")
        mBinding.loader?.visibility = View.GONE


        return mBinding.root
    }

}