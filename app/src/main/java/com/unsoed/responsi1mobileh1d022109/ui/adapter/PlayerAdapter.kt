package com.unsoed.responsi1mobileh1d022109.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi1mobileh1d022109.R
import com.unsoed.responsi1mobileh1d022109.data.model.Player
import com.unsoed.responsi1mobileh1d022109.databinding.ItemPlayerBinding

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    private var players = listOf<Player>()

    fun submitList(newPlayers: List<Player>) {
        players = newPlayers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount() = players.size

    inner class PlayerViewHolder(
        private val binding: ItemPlayerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(player: Player) {
            binding.tvPlayerName.text = player.name
            binding.tvPlayerPosition.text = player.position ?: "Unknown Position"
            binding.tvPlayerNationality.text = player.nationality ?: "Unknown"

            // Set color based on position
            val colorResId = when (player.position?.uppercase()) {
                "GOALKEEPER" -> R.color.goalkeeper_yellow
                "DEFENCE" -> R.color.defender_blue
                "MIDFIELD" -> R.color.midfielder_green
                "OFFENCE", "FORWARD", "ATTACK" -> R.color.forward_red
                else -> R.color.position_default
            }

            binding.positionColorIndicator.setBackgroundColor(
                ContextCompat.getColor(binding.root.context, colorResId)
            )
        }
    }
}