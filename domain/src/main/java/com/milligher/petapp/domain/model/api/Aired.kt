package com.milligher.petapp.domain.model.api

import com.milligher.petapp.domain.model.api.Prop

data class Aired(
    val from: String,
    val prop: Prop,
    val string: String,
    val to: String
)