package com.ebelli

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebelli.result.NetworkResult
import com.ebelli.usecase.favorite.GetAllFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val getAllFavoritesUseCase: GetAllFavoritesUseCase) :
    ViewModel() {
    private val _favoriteViewState = MutableStateFlow(FavoriteViewState())
    val viewState = _favoriteViewState.asStateFlow()
init {
    getFavoriteList()
}
    fun getFavoriteList() {
        viewModelScope.launch {
            _favoriteViewState.update { it.copy(isLoading = true) }
            val response = getAllFavoritesUseCase.invoke()
            response.collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _favoriteViewState.update {
                            it.copy(favoriteList = result.data, isLoading = false)
                        }

                    }
                    else -> {
                        _favoriteViewState.update { it.copy(isLoading = false) }
                    }
                }
            }
        }
    }
}

data class FavoriteViewState(
    val favoriteList: List<com.ebelli.model.Character>? = null,
    val isLoading: Boolean = false
)