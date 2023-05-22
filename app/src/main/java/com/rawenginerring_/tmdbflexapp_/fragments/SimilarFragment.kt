package com.rawenginerring_.tmdbflexapp_.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore.SimilarAdapter
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentSimilarBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SimilarFragment : Fragment() {
 private lateinit var mBinding: FragmentSimilarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       mBinding = FragmentSimilarBinding.inflate(inflater,container,false)
        val isTvShow = arguments?.getString("TV")
        println("isTvShow: "+isTvShow)
        if(isTvShow == "TV"){
            mBinding.similar.adapter = SimilarAdapter(MovieDetails_.similarMovieInformation,"TV")
        }else{
            mBinding.similar.adapter = SimilarAdapter(MovieDetails_.similarMovieInformation,"NO")
        }

        mBinding?.loader?.visibility = View.GONE
        return mBinding.root
    }


}