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
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
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

    fun getAllCharacters(favorites: List<Character>?) {
        if (_charactersViewState.value.isLoading) return
        openState { it.copy(isLoading = true) }
        viewModelScope.launch {
            delay(1000)
            val pagedFlow = getCharacterUseCase.invoke()
            openState {
                it.copy(characters = pagedFlow.map {
                    it.map { character ->
                        Character(
                            character,
                            favorites?.contains(character) == true
                        )
                    }
                }, isLoading = false)
            }
        }
    }

    fun setFavorites(list: List<Character>?) {
        viewModelScope.launch {
            getAllCharacters(list)
        }
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
            _charactersViewState.update {
                it.copy(isLoading = true)
            }
            when (removeFromFavoriteUseCase.invoke(character)) {
                is NetworkResult.Success -> {
                    _charactersViewState.update {
                        it.copy(isLoading = false, updateFavoriteList = true)

                    }
                }
                is NetworkResult.Failed -> {
                    _charactersViewState.update {
                        it.copy(isLoading = false, updateFavoriteList = false)
                    }
                }
            }
        }
    }

    private fun addToFavorites(character: Character) {
        viewModelScope.launch {
            openState { it.copy(isLoading = true) }
            when (val response = addToFavoriteUseCase.invoke(character)) {
                is NetworkResult.Success -> {
                    openState { it.copy(isLoading = false, updateFavoriteList = true) }
                }
                is NetworkResult.Failed -> {
                    openState { it.copy(isLoading = false, updateFavoriteList = false) }
                }
            }
        }
    }

    private fun openState(block: (CharactersViewState) -> CharactersViewState) {
        _charactersViewState.update {
            block(it)
        }
    }

    fun consumeUpdate() {
        _charactersViewState.update { it.copy(updateFavoriteList = false) }
    }
}

data class CharactersViewState(
    val isLoading: Boolean = false,
    val characters: Flow<PagingData<Character>>? = null,
    val favorites: List<Character>? = null,
    val updateFavoriteList: Boolean = false
)