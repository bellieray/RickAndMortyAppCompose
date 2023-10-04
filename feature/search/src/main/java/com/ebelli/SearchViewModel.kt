package com.ebelli

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebelli.model.Character
import com.ebelli.repository.character.CharacterRepository
import com.ebelli.result.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val characterRepository: CharacterRepository) :
    ViewModel() {
    private val _searchViewState = MutableStateFlow(SearchViewState())
    val searchViewState = _searchViewState.asStateFlow()

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            when (val response = characterRepository.getAllCharacters(1)) {
                is NetworkResult.Success -> _searchViewState.update {
                    it.copy(characters = response.data?.results)
                }
                else -> {}
            }
        }
    }

    fun makeSearch(text: String) {
        val updatedList = _searchViewState.value.characters?.filter {
            it.name.contains(text,true) or it.location.name.contains(
                text, true
            )
        }
        _searchViewState.update { it.copy(filterValues = updatedList) }
    }
}


data class SearchViewState(
    val characters: List<Character>? = null,
    val filterValues: List<Character>? = null
)