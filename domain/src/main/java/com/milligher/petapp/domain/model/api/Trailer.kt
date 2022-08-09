package com.milligher.petapp.domain.model.api

data class Trailer(
    val embed_url: String,
    val images: ImagesX,
    val url: String,
    val youtube_id: String
)