package com.dicoding.md_herbalens.model

import com.google.gson.annotations.SerializedName

data class PlantResponse(

	@field:SerializedName("plant_id")
	val plantId: Int,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("recipes")
	val recipes: List<String>,

	@field:SerializedName("classis")
	val classis: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("taxonomy")
	val taxonomy: Taxonomy,

	@field:SerializedName("kingdom")
	val kingdom: String,

	@field:SerializedName("benefit")
	val benefit: List<String>,

	@field:SerializedName("division")
	val division: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("genus")
	val genus: String,

	@field:SerializedName("species")
	val species: String,

	@field:SerializedName("ordo")
	val ordo: String,

	@field:SerializedName("family")
	val family: String,

	@field:SerializedName("plant_name")
	val plantName: String
)

data class Taxonomy(

	@field:SerializedName("division")
	val division: String,

	@field:SerializedName("classis")
	val classis: String,

	@field:SerializedName("genus")
	val genus: String,

	@field:SerializedName("species")
	val species: String,

	@field:SerializedName("ordo")
	val ordo: String,

	@field:SerializedName("family")
	val family: String,

	@field:SerializedName("kingdom")
	val kingdom: String
)
