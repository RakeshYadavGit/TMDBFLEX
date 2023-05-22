package com.rawenginerring_.tmdbflexapp_.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenginerring_.tmdbflexapp_.Adapter.ViewPagerAdapter
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentBookmarkBinding


class BookmarkFragment : Fragment() {

    private lateinit var mBinding: FragmentBookmarkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding =FragmentBookmarkBinding.inflate(inflater,container,false)
        val bundle = Bundle()
        setupViewPager(bundle)
        return  mBinding.root
    }

    private fun setupViewPager(bundle: Bundle) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        val moviesimilarFragment = MovieBookmarkFragment()
        adapter.addFragment(moviesimilarFragment, "Movie")

        val tvsimilarFragment = TvShowBookmarkFragment()
        adapter.addFragment(tvsimilarFragment, "Tv Show")

        mBinding.viewPager.adapter = adapter

        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
        mBinding.tabLayout.getTabAt(0)?.text = "Movie"
        mBinding.tabLayout.getTabAt(1)?.text = "TV Show"
    }


}