package com.messieyawo.mymoviepaginationexample.ui.favorite

import androidx.lifecycle.ViewModel
import com.messieyawo.mymoviepaginationexample.data.local.FavoriteMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
  private val repository: FavoriteMovieRepository
) : ViewModel(){
    val movies = repository.getFavoriteMovies()
}