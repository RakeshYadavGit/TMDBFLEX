package com.rawenginerring_.tmdbflexapp_.fragments
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenginerring_.tmdbflexapp_.Adapter.*
import com.rawenginerring_.tmdbflexapp_.DataFactory.MovieDataFactory.getLatestMovieChildren
import com.rawenginerring_.tmdbflexapp_.DataFactory.MovieDataFactory.getLatestTVShowChildren
import com.rawenginerring_.tmdbflexapp_.DataFactory.MovieDataFactory.getNowPlayingMovieChildren
import com.rawenginerring_.tmdbflexapp_.DataFactory.MovieDataFactory.getPopularTVShowChildren
import com.rawenginerring_.tmdbflexapp_.DataFactory.MovieDataFactory.getTopRatedChildren
import com.rawenginerring_.tmdbflexapp_.DataFactory.MovieDataFactory.getTopRatedTVShowChildren
import com.rawenginerring_.tmdbflexapp_.activity_.ShowMoreActivity
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var mBinding: FragmentHomeBinding? = null
    private lateinit var trendingMovieAdapter: TrendingMovieAdapter
    private lateinit var trendingTVShowAdapter: TrendingTVShowAdapter
    private lateinit var popularMoviesAdapter: PopularMoviesAdapter
    private lateinit var popularTVShowAdapter: PopularTVShowAdapter
    private lateinit var topRatedMoviesAdapter: TopRatedMoviesAdapter
    private lateinit var topRatedTVShowAdapter: TopRatedTVShowAdapter
    private lateinit var silder: UpcomingMovieSliderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLatestMovieChildren { children ->
            trendingMovieAdapter = TrendingMovieAdapter(children)
            mBinding?.trendingMovies?.adapter = trendingMovieAdapter
            mBinding?.slider?.setInterval(3000)
            val adapter = UpcomingMovieSliderAdapter(children)
            mBinding?.slider?.setAdapter(adapter)
            mBinding?.loader?.visibility = View.GONE
        }

        getTopRatedChildren { children ->
            topRatedMoviesAdapter = TopRatedMoviesAdapter(children)
            mBinding?.topRatedMovies?.adapter = topRatedMoviesAdapter
        }

        getNowPlayingMovieChildren {children ->
        popularMoviesAdapter = PopularMoviesAdapter(children)
        mBinding?.popularMovies?.adapter = popularMoviesAdapter
    }

        getPopularTVShowChildren {children ->
            popularTVShowAdapter = PopularTVShowAdapter(children)
            mBinding?.popularTv?.adapter = popularTVShowAdapter
        }

        getTopRatedTVShowChildren{children ->
            topRatedTVShowAdapter = TopRatedTVShowAdapter(children)
            mBinding?.topRatedTv?.adapter = topRatedTVShowAdapter
        }

        getLatestTVShowChildren {children ->
            trendingTVShowAdapter = TrendingTVShowAdapter(children)
            mBinding?.trendingTvShow?.adapter = trendingTVShowAdapter
        }
        setupClickListeners()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    private fun setupClickListeners() {
        mBinding?.apply {
            trendingMovieMore.setOnClickListener {
                startActivity(Intent(requireContext(), ShowMoreActivity::class.java).putExtra("Message","trendingMovieMore"))
            }
            trendingTvShowsMore.setOnClickListener {
                startActivity(Intent(requireContext(), ShowMoreActivity::class.java).putExtra("Message","trendingTvShowsMore"))
            }
            popularTvShowShowMore.setOnClickListener {
                startActivity(Intent(requireContext(), ShowMoreActivity::class.java).putExtra("Message","popularTvShowShowMore"))
            }
            popularMoviesShowMore.setOnClickListener {
                startActivity(Intent(requireContext(), ShowMoreActivity::class.java).putExtra("Message","popularMoviesShowMore"))
            }
            topRatedMoviesShowMore.setOnClickListener {
                startActivity(Intent(requireContext(), ShowMoreActivity::class.java).putExtra("Message","topRatedMoviesShowMore"))
            }
            topRatedTvshowShowMore.setOnClickListener {
                startActivity(Intent(requireContext(), ShowMoreActivity::class.java).putExtra("Message","topRatedTvshowShowMore"))
            }
        }
    }

}