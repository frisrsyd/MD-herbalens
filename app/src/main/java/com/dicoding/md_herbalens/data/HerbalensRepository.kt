package com.dicoding.md_herbalens.data

import com.dicoding.md_herbalens.api.ApiConfig
import com.dicoding.md_herbalens.model.PlantResponse
import retrofit2.Call

class HerbalensRepository {
    private val apiService = ApiConfig.getApiService()
    private val plantList = mutableListOf<PlantResponse>()

    fun getAllPlants(): Call<List<PlantResponse>> = apiService.getAllPlants()

    fun getPlantById(id: Int) = apiService.getDetailPlant(id)

    fun getPlantByName(name: String) = apiService.getPlants(name)

    companion object{
        @Volatile
        private var instance:HerbalensRepository? =null

        fun getInstance(): HerbalensRepository {
            return instance?: synchronized(this){
                HerbalensRepository().apply {
                    instance=this
                }
            }

        }
    }
}