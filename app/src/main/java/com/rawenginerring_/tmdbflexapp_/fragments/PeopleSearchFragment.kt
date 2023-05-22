package com.rawenginerring_.tmdbflexapp_.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore.PeopleAdapter
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentPeopleSearchBinding


class PeopleSearchFragment : Fragment() {

    private lateinit var mBinding: FragmentPeopleSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       mBinding = FragmentPeopleSearchBinding.inflate(inflater,container,false)

        mBinding.peopleSearchFragment.adapter = PeopleAdapter(MovieDetails_.searchPeople)
        mBinding?.loader?.visibility = View.GONE

        return mBinding.root
    }

}