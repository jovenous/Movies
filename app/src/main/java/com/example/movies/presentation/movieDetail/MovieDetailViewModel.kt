package com.example.movies.presentation.movieDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.R
import com.example.movies.data.entities.Actor
import com.example.movies.data.entities.MovieDetails
import com.example.movies.data.entities.Review
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel() {

    sealed class MovieState() {
        data object Loading : MovieState()
        data object Error : MovieState()
        class Success(
            val data: MovieDetails
        ) : MovieState()
    }

    val state = MutableStateFlow<MovieState>(MovieState.Loading)

    init {
        state.value = MovieState.Loading
        viewModelScope.launch {
            delay(1000)
            state.value = MovieState.Success(
                MovieDetails(
                    id = 1,
                    name = "Spiderman",
                    imgBG = R.drawable.detail_image_bg,
                    imgFG = R.drawable.detail_image_fg,
                    rating = 9.5f,
                    year = "2021",
                    genre = "Action",
                    duration = 148,
                    text = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
                    reviews = listOf(Review(id = 0, text = "Review1", username = "user1", icon = "icon1", rate = 6.3f)),
                    cast = listOf(Actor(id = 0, name = "Tom Holand", icon = "icon1"))
                )
            )
        }


    }
}