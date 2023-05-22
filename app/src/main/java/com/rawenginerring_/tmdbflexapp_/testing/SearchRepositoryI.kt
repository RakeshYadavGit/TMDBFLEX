package com.rawenginerring_.tmdbflexapp_.testing


import io.reactivex.Observable

interface SearchRepositoryI {
    fun getMovie(page : String,query : String,type : SmallItemList.Type) : Observable<Search>
}