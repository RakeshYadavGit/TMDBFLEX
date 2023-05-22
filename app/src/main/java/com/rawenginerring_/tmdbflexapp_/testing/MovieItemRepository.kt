package com.rawenginerring_.tmdbflexapp_.testing

import android.util.Log
import io.reactivex.Observable

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.atomic.AtomicReference

@Suppress("UNREACHABLE_CODE")
class MovieItemRepository(private val movieItemRequests : MovieItemRequests?) :
    MovieItemRepositoryI {

    override fun getMovieDetails(id: String): Observable<Quadruple<MovieInfo, Credits, Review, MovieList>> {
        return Observable.create < Quadruple < MovieInfo, Credits, Review, MovieList >> { emitter ->
            val movieInfoCall = movieItemRequests?.getMovieInfo(id)
            val creditsCall = movieItemRequests?.getCredits(id)
            val reviewsCall = movieItemRequests?.getReviews(id)
            val similarMoviesCall = movieItemRequests?.getSimilar(id)

            val movieInfoRef = AtomicReference<MovieInfo>()
            val creditsRef = AtomicReference<Credits>()
            val reviewsRef = AtomicReference<Review>()
            val similarMoviesRef = AtomicReference<MovieList>()

            movieInfoCall?.enqueue(object : Callback<MovieInfo> {
                override fun onResponse(call: Call<MovieInfo>, response: Response<MovieInfo>) {
                    val movieInfo = response.body()
                    movieInfoRef.set(movieInfo)
                    val credits = creditsRef.get()
                    val reviews = reviewsRef.get()
                    val similarMovies = similarMoviesRef.get()
                    if (credits != null && movieInfo != null && reviews != null && similarMovies != null) {
                        emitter.onNext(Quadruple(movieInfo, credits, reviews, similarMovies))
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<MovieInfo>, t: Throwable) {
                    emitter.onError(t)
                }
            })

            creditsCall?.enqueue(object : Callback<Credits> {
                override fun onResponse(call: Call<Credits>, response: Response<Credits>) {
                    val credits = response.body()
                    creditsRef.set(credits)
                    val movieInfo = movieInfoRef.get()
                    val reviews = reviewsRef.get()
                    val similarMovies = similarMoviesRef.get()
                    if (credits != null && movieInfo != null && reviews != null && similarMovies != null) {
                        emitter.onNext(Quadruple(movieInfo, credits, reviews, similarMovies))
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<Credits>, t: Throwable) {
                    emitter.onError(t)
                }
            })

            reviewsCall?.enqueue(object : Callback<Review> {
                override fun onResponse(call: Call<Review>, response: Response<Review>) {
                    val reviews = response.body()
                    reviewsRef.set(reviews)
                    val credits = creditsRef.get()
                    val movieInfo = movieInfoRef.get()
                    val similarMovies = similarMoviesRef.get()
                    if (credits != null && movieInfo != null && reviews != null && similarMovies != null) {
                        emitter.onNext(Quadruple(movieInfo, credits, reviews, similarMovies))
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<Review>, t: Throwable) {
                    emitter.onError(t)
                }
            })

            similarMoviesCall?.enqueue(object : Callback<MovieList> {
                override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                    val similarMovies = response.body()
                    similarMoviesRef.set(similarMovies)
                    val credits = creditsRef.get()
                    val movieInfo = movieInfoRef.get()
                    val reviews = reviewsRef.get()
                    if (credits != null && movieInfo != null && reviews != null && similarMovies != null) {
                        emitter.onNext(Quadruple(movieInfo, credits, reviews, similarMovies))
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<MovieList>, t: Throwable) {
                    emitter.onError(t)
                }
            })

            emitter.setCancellable {
                movieInfoCall?.cancel()
                creditsCall?.cancel()
                reviewsCall?.cancel()
                similarMoviesCall?.cancel()
            }
        }
    }
    override fun getMovieInfo(id: String): Observable<MovieResponse> {
        return Observable.create<MovieResponse> { emitter ->
            movieItemRequests?.getMovieInfo(id)?.enqueue(object : Callback<MovieInfo> {

                override fun onResponse(call: Call<MovieInfo>, response: Response<MovieInfo>) {

                    Log.i("sdjdsvc","${response.toString()}")
                    Log.i("sdjdsvc","${response.body()}")

                    response.body()?.let {
                        val movieResponse = MovieResponse()
                        movieResponse.type = MovieResponse.Type.MOVIE_INFO
                        movieResponse.data = it
                        emitter.onNext(movieResponse)
                        emitter.onComplete()
                    } ?: run {
                        emitter.onNext(MovieResponse())
                        emitter.onComplete()
                    }

                }

                override fun onFailure(call: Call<MovieInfo>, t: Throwable) {
                    emitter.onError(t)
                    Log.i("dshgczvc", "" + t.message)
                }

            })
        }
    }
    override fun getCredits(id: String): Observable<MovieResponse> {

        return Observable.create<MovieResponse> { emitter ->

            movieItemRequests?.getCredits(id)?.enqueue(object : Callback<Credits> {

                override fun onResponse(call: Call<Credits>, response: Response<Credits>) {
                    Log.i("dchjdbjsd",""+response.toString())
                    response.body()?.let {

                        val movieResponse = MovieResponse()
                        movieResponse.type = MovieResponse.Type.CREDIT
                        movieResponse.data = it
                        emitter.onNext(movieResponse)
                        emitter.onComplete()
                    } ?: run {
                        emitter.onNext(MovieResponse())
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<Credits>, t: Throwable) {
                    emitter.onError(t)
                    Log.i("dshgczvc", "not getting crew" + t.message)
                }


            })

        }
    }
    override fun getReviews(id: String): Observable<MovieResponse> {
        return Observable.create<MovieResponse> { emitter ->
            movieItemRequests?.getReviews(id)?.enqueue(object : Callback<Review> {

                override fun onResponse(call: Call<Review>, response: Response<Review>) {
                    Log.i("dshgczvc", "" + response.toString())
                    response.body()?.let {
                        Log.i("dshgczvc", "" + it.toString())
                        val movieResponse = MovieResponse()
                        movieResponse.type = MovieResponse.Type.REVIEW
                        movieResponse.data = it
                        emitter.onNext(movieResponse)
                        emitter.onComplete()
                    } ?: run {
                        emitter.onNext(MovieResponse())
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<Review>, t: Throwable) {
                    emitter.onError(t)
                    Log.i("dshgczvc", "" + t.message)
                }
            })

        }
    }
    override fun getSimilars(id: String): Observable<MovieResponse> {
        return Observable.create<MovieResponse> { emitter ->
            movieItemRequests?.getSimilar(id)?.enqueue(object : Callback<MovieList> {
                override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                    response.body()?.let {
                        val movieResponse = MovieResponse()
                        movieResponse.type = MovieResponse.Type.SIMILAR
                        movieResponse.data = it
                        emitter.onNext(movieResponse)
                        emitter.onComplete()
                    } ?: run {
                        emitter.onNext(MovieResponse())
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<MovieList>, t: Throwable) {
                    emitter.onError(t)
                    Log.i("dshgczvc", "" + t.message)
                }
            })
        }
    }

    override fun getSimilars(id: String, page: String): Observable<MovieResponse> {
        return Observable.create<MovieResponse> { emitter ->
            movieItemRequests?.getSimilar(id,page)?.enqueue(object : Callback<MovieList> {
                override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                    response.body()?.let {
                        val movieResponse = MovieResponse()
                        movieResponse.type = MovieResponse.Type.SIMILAR
                        movieResponse.data = it
                        emitter.onNext(movieResponse)
                        emitter.onComplete()
                    } ?: run {
                        emitter.onNext(MovieResponse())
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<MovieList>, t: Throwable) {
                    emitter.onError(t)
                    Log.i("dshgczvc", "" + t.message)
                }
            })
        }
    }
}