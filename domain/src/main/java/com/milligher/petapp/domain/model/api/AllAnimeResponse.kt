package com.milligher.petapp.domain.model.api

data class AllAnimeResponse(
    val `data`: List<Anime>,
    val links: Links,
    val meta: Meta,
    val pagination: Pagination
)