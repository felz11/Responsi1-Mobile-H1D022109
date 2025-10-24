package com.unsoed.responsi1mobileh1d022109

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.responsi1mobileh1d022109.data.model.Player
import com.unsoed.responsi1mobileh1d022109.databinding.ActivitySquadBinding
import com.unsoed.responsi1mobileh1d022109.ui.adapter.PlayerAdapter

class SquadActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySquadBinding
    private lateinit var adapter: PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Team Squad"

        setupRecyclerView()
        loadSquadData()
    }

    private fun setupRecyclerView() {
        adapter = PlayerAdapter()
        binding.rvPlayers.apply {
            layoutManager = LinearLayoutManager(this@SquadActivity)
            adapter = this@SquadActivity.adapter
        }
    }

    private fun loadSquadData() {
        val squad = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableArrayListExtra("SQUAD_LIST", Player::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableArrayListExtra<Player>("SQUAD_LIST")
        }

        if (squad.isNullOrEmpty()) {
            showNoData()
        } else {
            adapter.submitList(squad)
            binding.rvPlayers.visibility = View.VISIBLE
            binding.tvNoData.visibility = View.GONE
        }
    }

    private fun showNoData() {
        binding.tvNoData.visibility = View.VISIBLE
        binding.rvPlayers.visibility = View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}