package com.rawenginerring_.tmdbflexapp_.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore.SearchMovieAdapter
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentTvShowSearchBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TvShowSearchFragment : Fragment() {

    private lateinit var mBinding: FragmentTvShowSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTvShowSearchBinding.inflate(inflater,container,false)

        mBinding.tvShowSearchFragment.adapter = SearchMovieAdapter(MovieDetails_.searchTv,"TV")
        mBinding?.loader?.visibility = View.GONE

        return  mBinding.root
    }


}