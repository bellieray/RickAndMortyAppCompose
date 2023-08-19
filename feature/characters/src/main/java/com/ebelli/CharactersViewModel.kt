package com.ebelli

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebelli.usecase.character.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val getCharacterUseCase: GetCharacterUseCase) :
    ViewModel() {
    private val _charactersViewState: MutableStateFlow<CharactersViewState> =
        MutableStateFlow(CharactersViewState())
    val viewState = _charactersViewState.asStateFlow()

    fun getAllCharacters(pageNumber : Int) {
        viewModelScope.launch {
            openState { it.copy(isLoading = false) }
            when(val response = getCharacterUseCase.invoke(pageNumber)){

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
)