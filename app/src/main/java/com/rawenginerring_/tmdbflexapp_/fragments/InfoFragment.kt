package com.rawenginerring_.tmdbflexapp_.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rawenginerring_.tmdbflexapp_.db.bookmark.Bookmark
import com.rawenginerring_.tmdbflexapp_.db.bookmark.BookmarkDatabaseHelper
import com.rawenginerring_.tmdbflexapp_.Adapter.GenresAdapter
import com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore.CrewAdapter
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.activity_.CrewActivity
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    private var mBinding: FragmentInfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentInfoBinding.inflate(inflater, container, false)
        val dbHelper = BookmarkDatabaseHelper(requireContext())
        val isTvShow = arguments?.getString("TV")
        if(isTvShow=="TV"){
            mBinding!!.title.text = MovieDetails_.movieInformation.name_
        }else{
            mBinding!!.title.text = MovieDetails_.movieInformation.title

        }
        val adapter = GenresAdapter(MovieDetails_.movieInformation)
        mBinding!!.genres.adapter = adapter
        mBinding!!.status.text = MovieDetails_.movieInformation.status
        mBinding!!.releaseDate.text = MovieDetails_.movieInformation.getreleaseDate()
        mBinding!!.revenue.text = MovieDetails_.movieInformation.getRevenue()
        mBinding!!.originalLanguage.text = MovieDetails_.movieInformation.originalLanguage
        mBinding!!.description.text = MovieDetails_.movieInformation.overview
        mBinding!!.runtime.text = MovieDetails_.movieInformation.getRuntime()
        mBinding!!.year.text = MovieDetails_.movieInformation.getYear()
        mBinding!!.budget.text = MovieDetails_.movieInformation.getBudget()
        mBinding!!.producationCompanies.text = MovieDetails_.movieInformation.getProductionCompanies()
        mBinding!!.duration.text = MovieDetails_.movieInformation.getRuntime()
        mBinding!!.originalTitle.text = MovieDetails_.movieInformation.originalTitle
        mBinding!!.crew.adapter = CrewAdapter(MovieDetails_.movieCreditInformation)
        mBinding?.loader?.visibility = View.GONE

        val hasBookmark = dbHelper.hasBookmark(MovieDetails_.movieInformation.id.toString())
        if (hasBookmark) {
            mBinding?.imageView13?.setImageResource(R.drawable.bookmark)
        }


        mBinding?.imageView13!!.setOnClickListener {
            val movieId = MovieDetails_.movieInformation.id.toString()
            val title = if (isTvShow == "TV") {
                MovieDetails_.movieInformation.name_
            } else {
                MovieDetails_.movieInformation.title
            }
            val posterUrl = MovieDetails_.movieInformation.posterPath

            val existingBookmark = dbHelper.hasBookmark(movieId)
            if (existingBookmark) {
                dbHelper.deleteBookmark(movieId)
                mBinding?.imageView13?.setImageResource(R.drawable.bookmark_selection)
                Toast.makeText(context, "Bookmark removed", Toast.LENGTH_SHORT).show()
            } else {
                val bookmark = Bookmark(
                    movieId,
                    title.toString(),
                    posterUrl.toString(),
                    MovieDetails_.movieInformation.getYear().toString(),
                    MovieDetails_.movieInformation.voteAverage.toString(),
                    isTvShow.toString()
                )
                val result = dbHelper.addBookmark(bookmark)

                if (result > -1) {
                    mBinding?.imageView13?.setImageResource(R.drawable.bookmark)
                    Toast.makeText(context, "Bookmark added", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Bookmark could not be added", Toast.LENGTH_SHORT).show()
                }
            }
        }


        mBinding?.crewShowAllTexr?.setOnClickListener {
            startActivity(Intent(requireContext(), CrewActivity::class.java))
        }
        return mBinding?.root
    }
}