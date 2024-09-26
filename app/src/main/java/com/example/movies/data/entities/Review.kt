package com.example.movies.data.entities

data class Review(
    val id: Int,
    val text: String,
    val icon: String,
    val username: String,
    val rate: Float
)