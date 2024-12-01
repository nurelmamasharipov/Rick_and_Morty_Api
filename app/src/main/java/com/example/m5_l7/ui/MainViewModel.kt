package com.example.m5_l7.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.m5_l7.data.CharacterRepository
import com.example.m5_l7.data.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    fun getCharacters(): LiveData<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 30,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { repository.getPagingSource() }
        ).liveData
    }
}


