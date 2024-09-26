package com.example.movies.data.entities

data class MovieDetails(
    val id: Int,
    val name: String,
    val imgBG: Int,
    val imgFG: Int,
    val rating: Float,
    val year: String,
    val genre: String,
    val duration: Int,
    val text: String,
    val reviews: List<Review>,
    val cast: List<Actor>
)