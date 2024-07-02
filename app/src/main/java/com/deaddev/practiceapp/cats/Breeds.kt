package com.deaddev.practiceapp.cats

import com.deaddev.practiceapp.R

enum class Breeds(val nameId: Int, val descriptionId: Int) {
    MaineCoon(
        R.string.breed_maine_coon,
        R.string.breed_maine_coon_description
    ),
    Sphynx(
        R.string.breed_sphynx,
        R.string.breed_sphynx_description
    ),
    Ragdoll(
        R.string.breed_ragdoll,
        R.string.breed_ragdoll_description
    ),
    Abyssinian(
        R.string.breed_abyssinian,
        R.string.breed_abyssinian_description
    ),
    BritishShorthair(
        R.string.breed_british_shorthair,
        R.string.breed_british_shorthair_description
    ),
    RussianBlue(
        R.string.breed_russian_blue,
        R.string.breed_russian_blue_description
    ),
    Bengal(
        R.string.breed_bengal,
        R.string.breed_bengal_description
    );

    fun get_name_id(): Int = nameId

    fun get_description_id(): Int = descriptionId
}