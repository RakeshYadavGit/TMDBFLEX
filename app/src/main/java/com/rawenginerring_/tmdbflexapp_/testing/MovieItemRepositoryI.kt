package com.rawenginerring_.tmdbflexapp_.testing

import io.reactivex.Observable

interface MovieItemRepositoryI {


    fun getMovieInfo(id: String): Observable<MovieResponse>

    fun getCredits(id: String): Observable<MovieResponse>

    fun getReviews(id: String): Observable<MovieResponse>

    fun getSimilars(id: String): Observable<MovieResponse>

    fun getSimilars(id: String,page :String): Observable<MovieResponse>

    fun getMovieDetails(id: String): Observable<Quadruple<MovieInfo, Credits, Review, MovieList>>
}