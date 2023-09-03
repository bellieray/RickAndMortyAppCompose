package com.ebelli.usecase.character

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ebelli.model.CharacterResponse
import com.ebelli.paging.CharacterPagingSource
import com.ebelli.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val PAGE_SIZE = 20

class GetCharacterUseCaseImpl @Inject constructor(private val characterRepository: CharacterRepository) :
    GetCharacterUseCase {
    override suspend fun invoke(): Flow<PagingData<com.ebelli.model.Character>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = { CharacterPagingSource(characterRepository) }
        ).flow
    }

}