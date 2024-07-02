package com.deaddev.practiceapp.cats

object CatsRepository {
    val cats = arrayOf(
        CatBreedInfo(
            id = 0,
            breed = Breeds.Bengal,
            max_age = 12..15,
            imageUrl = "https://cdn2.thecatapi.com/images/sPMOo3Jn2.jpg",
        ),
        CatBreedInfo(
            id = 1,
            breed = Breeds.Abyssinian,
            max_age = 14..15,
            imageUrl = "https://cdn2.thecatapi.com/images/g1j3wRjgx.jpg",
        ),
        CatBreedInfo(
            id = 2,
            breed = Breeds.MaineCoon,
            max_age = 12..15,
            imageUrl = "https://cdn2.thecatapi.com/images/MmiojCuKC.jpg",
        ),
        CatBreedInfo(
            id = 3,
            breed = Breeds.Ragdoll,
            max_age = 12..17,
            imageUrl = "https://cdn2.thecatapi.com/images/83htMb1AJ.jpg",
        ),
        CatBreedInfo(
            id = 4,
            breed = Breeds.Sphynx,
            max_age = 12..14,
            imageUrl = "https://cdn2.thecatapi.com/images/Wd_Py_Mj8.jpg",
        ),
        CatBreedInfo(
            id = 5,
            breed = Breeds.RussianBlue,
            max_age = 10..16,
            imageUrl = "https://cdn2.thecatapi.com/images/2bPsrIcp-.jpg",
        ),
        CatBreedInfo(
            id = 6,
            breed = Breeds.BritishShorthair,
            max_age = 12..17,
            imageUrl = "https://cdn2.thecatapi.com/images/_7U4xGLO_.jpg",
        ),
        )

}