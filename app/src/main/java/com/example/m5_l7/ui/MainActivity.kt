package com.example.m5_l7.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m5_l7.R
import com.example.m5_l7.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
        binding.rvCharacters.adapter = adapter

        viewModel.getCharacters().observe(this) { data ->
            adapter.submitData(lifecycle, data)
        }

        adapter.setOnItemClickListener { character ->
            val intent = Intent(this, CharacterDetailsActivity::class.java).apply {
                putExtra("characterId", character.id)
            }
            startActivity(intent)
        }
    }
}


