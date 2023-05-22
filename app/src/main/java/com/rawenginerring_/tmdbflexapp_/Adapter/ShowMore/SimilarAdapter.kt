package com.rawenginerring_.tmdbflexapp_.Adapter.ShowMore

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rawenginerring_.tmdbflexapp_.Data.MovieDetails_
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.activity_.DetailsActivity
import com.rawenginerring_.tmdbflexapp_.testing.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SimilarAdapter(private val itemList: MovieList, private val isTvShow: String) :
    RecyclerView.Adapter<SimilarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.similar, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList.results[position]
        holder.bind(item,holder)
        holder.itemView.setOnClickListener {
            val movieId = item.id.toString()

            val movieInfoObservable = MovieDetails_.movieRepo.getMovieInfo(movieId)
            val creditsObservable = MovieDetails_.movieRepo.getCredits(movieId)
            val reviewsObservable = MovieDetails_.movieRepo.getReviews(movieId)
            val similarMoviesObservable = MovieDetails_.movieRepo.getSimilars(movieId)

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

    override fun getItemCount(): Int {
        return itemList.results.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieName: TextView = itemView.findViewById(R.id.textView3)
        private val movieImage: ImageView = itemView.findViewById(R.id.poster)
        private val movieRating: TextView = itemView.findViewById(R.id.textView4)
        private val movieYear: TextView = itemView.findViewById(R.id.textView2)
        fun bind(item: MovieList.Result, holder: ViewHolder) {
            if (isTvShow == "TV") {
                movieName.text = item.name
                println("item.name" + item.name)
            } else {
                movieName.text = item.title
            }

            val IMAGE_BASE = "https://image.tmdb.org/t/p/w185/"
            Glide.with(holder.itemView)
                .load(IMAGE_BASE + item.posterPath)
                .into(holder.movieImage)

            movieRating.text = item.voteAverage.toString()
            movieYear.text = item.releaseDate
        }
    }
}
