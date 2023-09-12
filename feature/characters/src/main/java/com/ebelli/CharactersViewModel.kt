package com.ebelli

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.ebelli.model.Character
import com.ebelli.result.NetworkResult
import com.ebelli.usecase.character.GetCharacterUseCase
import com.ebelli.usecase.favorite.AddToFavoriteUseCase
import com.ebelli.usecase.favorite.RemoveFromFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val addToFavoriteUseCase: AddToFavoriteUseCase,
    private val removeFromFavoriteUseCase: RemoveFromFavoriteUseCase
) :
    ViewModel() {
    private val _charactersViewState: MutableStateFlow<CharactersViewState> =
        MutableStateFlow(CharactersViewState())
    val viewState = _charactersViewState.asStateFlow()

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        viewModelScope.launch {
            openState { it.copy(isLoading = true) }
            val pagedFlow = getCharacterUseCase.invoke()
            openState { it.copy(characters = pagedFlow, isLoading = false) }
        }
    }

    fun setFavorites(list: List<com.ebelli.model.Character>?) {
        _charactersViewState.update { it.copy(favorites = list) }
    }

    fun modifyFavorites(character: Character) {
        if (character.isFavorite) {
            removeFromFavorites(character)
        } else {
            addToFavorites(character)
        }
    }

    private fun removeFromFavorites(character: Character) {
        viewModelScope.launch {
            when (val response = removeFromFavoriteUseCase.invoke(character)) {
                is NetworkResult.Success -> {}
                is NetworkResult.Failed -> {}
            }
        }
    }

    private fun addToFavorites(character: com.ebelli.model.Character) {
        viewModelScope.launch {
            when (val response = addToFavoriteUseCase.invoke(character)) {
                is NetworkResult.Success -> {}
                is NetworkResult.Failed -> {}
            }
        }
    }

    private fun openState(block: (CharactersViewState) -> CharactersViewState) {
        _charactersViewState.update {
            block(it)
        }
    }
}

data class CharactersViewState(
    val isLoading: Boolean = false,
    val characters: Flow<PagingData<Character>>? = null,
    val favorites: List<Character>? = null
)