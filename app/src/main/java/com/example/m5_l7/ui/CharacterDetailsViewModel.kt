package com.example.m5_l7.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m5_l7.data.CharacterRepository
import com.example.m5_l7.data.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _character = MutableLiveData<Character>()
    val character: MutableLiveData<Character> = _character

    fun loadCharacter(id: Int) {
        viewModelScope.launch {
            try {
                val result = repository.getCharacterById(id)
                _character.postValue(result)
            } catch (e: Exception) {
                Log.e("ololo", "Error loading character", e)
            }
        }
    }
}
