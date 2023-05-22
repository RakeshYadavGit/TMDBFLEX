package com.rawenginerring_.tmdbflexapp_.activity_

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore.*
import com.rawenginerring_.tmdbflexapp_.DataFactory.MovieDataFactory
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.databinding.ActivityShowMoreBinding

class ShowMoreActivity : AppCompatActivity() {
    private lateinit var trendingMovieAdapterShowMore: TrendingMovieAdapterShowMore
    private lateinit var trendingTVShowAdapterShowMore: TrendingTVShowAdapterShowMore
    private lateinit var popularMovieAdapterShowMore: PopularMovieAdapterShowMore
    private lateinit var popularTvShowAdapterShowMore: PopularTvShowAdapterShowMore
    private lateinit var topRatedMovieAdapterShowMore: TopRatedMovieAdapterShowMore
    private lateinit var topRatedTVShowAdapterShowMore: TopRatedTVShowAdapterShowMore
    private lateinit var moreBinding: ActivityShowMoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val value:String = intent.getStringExtra("Message").toString()
        moreBinding = ActivityShowMoreBinding.inflate(layoutInflater)
        setContentView(moreBinding.root)
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.colorPrimary)))
        moreBinding.showMoreRecyclerView.layoutManager = GridLayoutManager(this, 2)

        if(value=="trendingMovieMore")
        {
            MovieDataFactory.getLatestMovieChildren { children ->
                trendingMovieAdapterShowMore = TrendingMovieAdapterShowMore(children)
                moreBinding.showMoreRecyclerView.adapter = trendingMovieAdapterShowMore
            }
        }

        if(value=="trendingTvShowsMore")
        {
            MovieDataFactory.getLatestTVShowChildren { children ->
                trendingTVShowAdapterShowMore = TrendingTVShowAdapterShowMore(children)
                moreBinding?.showMoreRecyclerView?.adapter = trendingTVShowAdapterShowMore
            }
        }

        if(value=="popularTvShowShowMore")
        {
            MovieDataFactory.getPopularTVShowChildren { children ->
                popularTvShowAdapterShowMore = PopularTvShowAdapterShowMore(children)
                moreBinding?.showMoreRecyclerView?.adapter = popularTvShowAdapterShowMore
            }
        }

        if(value=="popularMoviesShowMore")
        {
            MovieDataFactory.getNowPlayingMovieChildren { children ->
                popularMovieAdapterShowMore = PopularMovieAdapterShowMore(children)
                moreBinding?.showMoreRecyclerView?.adapter = popularMovieAdapterShowMore
            }
        }

        if(value=="topRatedMoviesShowMore")
        {
            MovieDataFactory.getTopRatedChildren { children ->
                topRatedMovieAdapterShowMore = TopRatedMovieAdapterShowMore(children)
                moreBinding?.showMoreRecyclerView?.adapter = topRatedMovieAdapterShowMore
            }
        }

        if(value=="topRatedTvshowShowMore")
        {
            MovieDataFactory.getTopRatedTVShowChildren { children ->
                topRatedTVShowAdapterShowMore = TopRatedTVShowAdapterShowMore(children)
                moreBinding?.showMoreRecyclerView?.adapter = topRatedTVShowAdapterShowMore
            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}