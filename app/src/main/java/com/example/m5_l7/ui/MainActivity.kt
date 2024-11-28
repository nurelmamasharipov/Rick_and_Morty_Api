package com.example.m5_l7.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m5_l7.R
import com.example.m5_l7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by viewModels<MainViewModel>()
    private val adapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
        binding.rvCharacters.adapter = adapter

        viewModel.getCharacters().observe(this){data ->
            adapter.submitData(lifecycle, data)
        }
    }
}