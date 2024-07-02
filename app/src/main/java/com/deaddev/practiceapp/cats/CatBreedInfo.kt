package com.deaddev.practiceapp.cats

data class CatBreedInfo(
    val id: Int,
    val imageUrl: String,
    val max_age: IntRange,
    val breed: Breeds
)