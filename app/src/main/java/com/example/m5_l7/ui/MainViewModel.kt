package com.example.m5_l7.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.m5_l7.data.models.Character
import com.example.m5_l7.paging.PagingSource

class MainViewModel : ViewModel() {

    fun getCharacters(): LiveData<PagingData<Character>>{
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 30,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {PagingSource()}
        ).liveData
    }
}