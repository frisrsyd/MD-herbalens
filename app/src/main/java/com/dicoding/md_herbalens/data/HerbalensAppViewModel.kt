package com.dicoding.md_herbalens.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.md_herbalens.model.PlantResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HerbalensAppViewModel(private val repository: HerbalensRepository) : ViewModel() {

    private val _plants = MutableStateFlow<List<PlantResponse>?>(null)
    val plants: StateFlow<List<PlantResponse>?> get() = _plants

    private val _plantsById = MutableStateFlow<PlantResponse?>(null)
    val plantsById: StateFlow<PlantResponse?> get() = _plantsById

    val plantsByName: StateFlow<List<PlantResponse>?> get() = _plants

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    private val _emailValue = mutableStateOf("")
    val emailValue: State<String> get() = _emailValue

    private val _passwordValue = mutableStateOf("")
    val passwordValue: State<String> get() = _passwordValue

    fun search(newQuery: String) {
        _query.value = newQuery
        val filteredList = _plants.value?.filter { plant ->
            plant.plantName.contains(newQuery, ignoreCase = true)
        }
        _plants.value = filteredList
    }

    fun setEmailValue(email: String) {
        _emailValue.value = email
    }

    fun setPasswordValue(password: String) {
        _passwordValue.value = password
    }

    fun getAllPlants() {
        viewModelScope.launch {
            repository.getAllPlants().enqueue(object : Callback<List<PlantResponse>> {
                override fun onResponse(
                    call: Call<List<PlantResponse>>,
                    response: Response<List<PlantResponse>>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _plants.value = responseBody
                        }
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<List<PlantResponse>>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
        }
    }

    fun getPlantById(id: Int) {
        viewModelScope.launch {
            repository.getPlantById(id).enqueue(object : Callback<PlantResponse> {
                override fun onResponse(
                    call: Call<PlantResponse>,
                    response: Response<PlantResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            _plantsById.value = responseBody
                            Log.d(TAG, "onResponse: ${responseBody.plantName}")
                        }
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }

            })
        }
    }
}