package com.ebelli.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ebelli.model.Character
import com.ebelli.repository.character.CharacterRepository
import com.ebelli.result.NetworkResult


class CharacterPagingSource(
    private val characterRepository: CharacterRepository
) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageNumber = params.key ?: 1

        return try {
            when (val response = characterRepository.getAllCharacters(pageNumber)) {
                is NetworkResult.Success -> {
                    val characters = response.data?.results.orEmpty()
                    LoadResult.Page(
                        data = characters,
                        prevKey = if (pageNumber == 1) null else pageNumber - 1,
                        nextKey = if (characters.isEmpty()) null else pageNumber + 1
                    )
                }
                is NetworkResult.Failed -> LoadResult.Error(Throwable(response.exception.toString()))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}