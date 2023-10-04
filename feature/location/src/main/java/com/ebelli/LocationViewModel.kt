package com.ebelli

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebelli.model.LocationInfo
import com.ebelli.result.NetworkResult
import com.ebelli.usecase.character.GetCharactersByIdUseCase
import com.ebelli.usecase.location.GetLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val getCharactersByIdUseCase: GetCharactersByIdUseCase
) :
    ViewModel() {
    private val _locationViewState = MutableStateFlow(LocationViewState())
    val locationViewState = _locationViewState.asStateFlow()

    init {
        fetchLocations()
    }

    private fun fetchLocations() {
        _locationViewState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            when (val response = getLocationsUseCase.invoke()) {
                is NetworkResult.Success -> {
                    _locationViewState.update {
                        it.copy(locations = response.data, isLoading = false)
                    }
                    response.data?.results?.get(0)?.let {
                        if(it.residents.isNotEmpty()) getByCharactersById(it.getIds())
                        updateList(it.id)
                    }
                }
                else -> {
                    _locationViewState.update { it.copy(isLoading = false) }
                }
            }
        }
    }

    fun updateList(id: Int) {
        _locationViewState.update {
            it.copy(locations = _locationViewState.value.locations?.copy(results = _locationViewState.value.locations?.results?.map { response ->
                response.copy(isFavorite = response.id == id)
            }))
        }
    }

    fun getByCharactersById(ids: List<String>) {
        _locationViewState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            when (val response = getCharactersByIdUseCase.invoke(ids)) {
                is NetworkResult.Success -> {
                    _locationViewState.update {
                        it.copy(characters = response.data, isLoading = false)
                    }
                }
                else -> {
                    _locationViewState.update { it.copy(isLoading = false, characters = emptyList())}
                }
            }
        }
    }
}

data class LocationViewState(
    val locations: LocationInfo? = null,
    val isLoading: Boolean = false,
    val characters: List<com.ebelli.model.Character>? = null
)