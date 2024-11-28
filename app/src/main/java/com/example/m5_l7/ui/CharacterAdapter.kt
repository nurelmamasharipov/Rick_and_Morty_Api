package com.example.m5_l7.ui

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m5_l7.data.models.Character
import com.example.m5_l7.databinding.ItemRickAndMortyBinding

class CharacterAdapter : PagingDataAdapter<Character, CharacterAdapter.CharacterViewHolder>(CharacterDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemRickAndMortyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        character?.let { holder.bind(it) }
    }

    class CharacterViewHolder(private val binding: ItemRickAndMortyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            binding.apply {
                tvName.text = character.name
                tvIsAlive.text = "${character.status} - ${character.species}"
                tvLocation.text = character.location?.name ?: "??"
                tvFirstPlace.text = character.location?.name ?: "??"


                Glide.with(ivAvatar.context)
                    .load(character.image)
                    .into(ivAvatar)
            }
        }
    }

    class CharacterDiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }
}