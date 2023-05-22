package com.rawenginerring_.tmdbflexapp_.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.activity_.SearchActivity
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentSearchBinding
import com.rawenginerring_.tmdbflexapp_.testing.SmallItemList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SearchFragment : Fragment() {
 private lateinit var mBinding: FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       mBinding = FragmentSearchBinding.inflate(inflater,container,false)
        (activity as AppCompatActivity).supportActionBar?.hide()

        mBinding.searchImage.setOnClickListener{
            val searchText =  mBinding.editSearchText.text.toString().trim()
//            Toast.makeText(requireContext(),"Please enter text! "+searchText, Toast.LENGTH_SHORT).show()

            if(searchText.isNotEmpty()){
                if (searchText.isNotEmpty()) {
//                    Toast.makeText(requireContext(),"Search Text "+ searchText, Toast.LENGTH_LONG).show()
                    println("searchText88"+searchText)
//                    val query = "Peter"
                    val page = "1"
                    MovieDetails_.searchRepo.getMovie(page, searchText, SmallItemList.Type.SEARCH_MOVIES)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            { search ->
                                MovieDetails_.searchMovie = search
                                println("MovieDetails_.searchMovie"+ MovieDetails_.searchMovie)
                            },
                            { error ->
                                //                    Toast.makeText(this,"Something wrong",Toast.l)
                            }
                        )
                    MovieDetails_.searchRepo.getMovie(page, searchText, SmallItemList.Type.SEARCH_TV)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            { search ->
                                MovieDetails_.searchTv = search
                            },
                            { error ->
//                    Toast.makeText(this,"Something wrong",Toast.l)
                            }
                        )
                    MovieDetails_.searchRepo.getMovie(page, searchText, SmallItemList.Type.PERSON)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            { search ->
                                MovieDetails_.searchPeople = search
                                startActivity(Intent(requireContext(),SearchActivity::class.java).putExtra("searchText",searchText))

                            },
                            { error ->
//                    Toast.makeText(this,"Something wrong",Toast.l)
                            }
                        )


                }
                else{
//                    Toast.makeText(requireContext(),"Search Text "+ searchText, Toast.LENGTH_LONG).show()
                }

            }
            else{
                Toast.makeText(requireContext(),"Please enter text!", Toast.LENGTH_SHORT).show()
            }
        }
        return mBinding.root
    }

}