package com.ebelli

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import com.ebelli.usecase.character.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val getCharacterUseCase: GetCharacterUseCase) :
    ViewModel() {
    private val _charactersViewState: MutableStateFlow<CharactersViewState> =
        MutableStateFlow(CharactersViewState())
    val viewState = _charactersViewState.asStateFlow()

    init {
        getAllCharacters(1)
    }

    private fun getAllCharacters(pageNumber: Int) {
        viewModelScope.launch {
            openState { it.copy(isLoading = false) }
            getCharacterUseCase.invoke(pageNumber).onEach { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _charactersViewState.update { it.copy(characters = result.data) }
                    }
                    else -> {}
                }
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
    val characters: CharacterResponse? = null
)