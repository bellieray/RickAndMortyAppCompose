package com.ebelli

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.ebelli.model.Character
import com.ebelli.usecase.character.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
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

    private fun openState(block: (CharactersViewState) -> CharactersViewState) {
        _charactersViewState.update {
            block(it)
        }
    }
}

data class CharactersViewState(
    val isLoading: Boolean = false,
    val characters: Flow<PagingData<Character>>? = null
)