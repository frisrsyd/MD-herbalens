package com.dicoding.md_herbalens.model

data class Plant(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val detail: ArrayList<Details>,
    val description: String,
    val benefit: ArrayList<String>,
    val listRecipe: ArrayList<String>,
)

data class Details(
    val kingdom: String,
    val division: String,
    val classis: String,
    val ordo: String,
    val family: String,
    val genus: String,
    val species: String,
)
