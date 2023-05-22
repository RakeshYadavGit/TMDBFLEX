package com.rawenginerring_.tmdbflexapp_.testing

import io.reactivex.Observable

interface TvShowRepositoryI {

    fun getTvShowInfo(id: String): Observable<MovieResponse>
    fun getCredits(id: String): Observable<MovieResponse>
    fun getReviews(id: String): Observable<MovieResponse>
    fun getSimilars(id: String): Observable<MovieResponse>
    fun getTvDetails(id: String): Observable<Quadruple<MovieInfo, Credits, Review, MovieList>>
}