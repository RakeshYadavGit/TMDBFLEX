package com.rawenginerring_.tmdbflexapp_.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.activity_.DetailsActivity
import com.rawenginerring_.tmdbflexapp_.databinding.SmallItemBinding
import com.rawenginerring_.tmdbflexapp_.models.TVShowModel
import com.rawenginerring_.tmdbflexapp_.testing.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PopularTVShowAdapter(private val children : List<TVShowModel>) : RecyclerView.Adapter<PopularTVShowAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SmallItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return 20
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        val child = children[position]
        Glide.with(holder.posterImage.context).load(IMAGE_BASE + child.poster).into(holder.posterImage)
        holder.tile.text = child.title
        holder.rating.text = child.vote_average
        holder.itemView.setOnClickListener {
            val movieId = child.id.toString()
            val movieInfoObservable = MovieDetails_.tvRepo.getTvShowInfo(movieId)
            val creditsObservable = MovieDetails_.tvRepo.getCredits(movieId)
            val reviewsObservable = MovieDetails_.tvRepo.getReviews(movieId)
            val similarMoviesObservable = MovieDetails_.tvRepo.getSimilars(movieId)

            Observable.zip(
                movieInfoObservable, creditsObservable, reviewsObservable, similarMoviesObservable,
                object : Function4<MovieResponse, MovieResponse, MovieResponse, MovieResponse, Quadruple<MovieInfo, Credits, Review, MovieList>> {
                    override fun invoke(
                        movieInfoResponse: MovieResponse,
                        creditsResponse: MovieResponse,
                        reviewsResponse: MovieResponse,
                        similarMoviesResponse: MovieResponse
                    ): Quadruple<MovieInfo, Credits, Review, MovieList> {
                        val movieInfo = movieInfoResponse.data as MovieInfo
                        val credits = creditsResponse.data as Credits
                        val reviews = reviewsResponse.data as Review
                        val similarMovies = similarMoviesResponse.data as MovieList

                        return Quadruple(movieInfo, credits, reviews, similarMovies)
                    }
                }
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { quadruple ->
                        val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
                        intent.putExtra("TV","TV")
                        MovieDetails_.movieInformation = quadruple.first
                        MovieDetails_.movieCreditInformation = quadruple.second
                        MovieDetails_.movieRevieInformation = quadruple.third
                        MovieDetails_.similarMovieInformation = quadruple.fourth
                        holder.itemView.context.startActivity(intent)
                    },
                    { error ->
                        Log.e("MovieRepo", "Error fetching movie info and credits", error)
                    }
                )
        }
    }

    inner class ViewHolder(private val binding: SmallItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tile : TextView = binding.title
        val posterImage: ImageView = binding.poster
        val rating: TextView = binding.rating
    }
}