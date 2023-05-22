package com.rawenginerring_.tmdbflexapp_.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenginerring_.tmdbflexapp_.db.bookmark.BookmarkDatabaseHelper
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentMovieBookmarkBinding
import com.rawenginerring_.tmdbflexapp_.db.bookmark.BookmarkAdapter


class MovieBookmarkFragment : Fragment() {
    private lateinit var mBinding: FragmentMovieBookmarkBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMovieBookmarkBinding.inflate(inflater,container,false)
        val dbHelper = BookmarkDatabaseHelper(requireContext())
        val bookmarks = dbHelper.getAllBookmarks(false)
        mBinding.movieBookmark.adapter = BookmarkAdapter(bookmarks)
        mBinding?.loader?.visibility = View.GONE

//        println("bookmarks"+bookmarks)
//        for (bookmark in bookmarks) {
//            Log.d(TAG, "Movie ID***:" +bookmark.movieId)
//            Log.d(TAG, "Title: ${bookmark.title}")
//            Log.d(TAG, "Poster URL: ${bookmark.posterUrl}")
//            Log.d(TAG, "Year: ${bookmark.year}")
//            Log.d(TAG, "rating: ${bookmark.rating}")
//            Log.d(TAG, "isTvshow: ${bookmark.isTvShow}")
//        }
        return  mBinding.root
    }
}