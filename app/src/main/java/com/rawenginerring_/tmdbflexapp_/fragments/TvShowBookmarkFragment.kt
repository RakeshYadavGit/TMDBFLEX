package com.rawenginerring_.tmdbflexapp_.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentTvShowBookmarkBinding
import com.rawenginerring_.tmdbflexapp_.db.bookmark.BookmarkAdapter
import com.rawenginerring_.tmdbflexapp_.db.bookmark.BookmarkDatabaseHelper

class TvShowBookmarkFragment : Fragment() {
   private lateinit var mBinding: FragmentTvShowBookmarkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTvShowBookmarkBinding.inflate(inflater,container,false)
        val dbHelper = BookmarkDatabaseHelper(requireContext())
        val bookmarks = dbHelper.getAllBookmarks(true)
        mBinding.tvBookmark.adapter = BookmarkAdapter(bookmarks)
        mBinding?.loader?.visibility = View.GONE

        return  mBinding.root
    }

}