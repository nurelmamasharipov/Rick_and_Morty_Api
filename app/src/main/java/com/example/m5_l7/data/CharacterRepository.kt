package com.example.m5_l7.data

import androidx.paging.PagingSource
import com.example.m5_l7.data.models.Character
import com.example.m5_l7.paging.CharacterPagingSource
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun getPagingSource(): CharacterPagingSource {
        return CharacterPagingSource(apiService)
    }

    suspend fun getCharacterById(id: Int): Character {
        return apiService.getCharacterById(id)
    }
}

