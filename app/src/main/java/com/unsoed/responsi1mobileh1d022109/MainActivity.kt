package com.unsoed.responsi1mobileh1d022109

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.unsoed.responsi1mobileh1d022109.data.model.Player
import com.unsoed.responsi1mobileh1d022109.data.model.TeamResponse
import com.unsoed.responsi1mobileh1d022109.data.remote.ApiService
import com.unsoed.responsi1mobileh1d022109.data.repository.TeamRepository
import com.unsoed.responsi1mobileh1d022109.databinding.ActivityMainBinding
import com.unsoed.responsi1mobileh1d022109.utils.Constants
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val apiService = ApiService.create()
    private val repository = TeamRepository(apiService)
    private var teamData: TeamResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        loadTeamData()
        setupClickListeners()
    }

    private fun setupUI() {
        // Setup initial UI
        binding.tvClubName.text = getString(R.string.fc_st_pauli)
    }

    private fun loadTeamData() {
        showLoading(true)

        lifecycleScope.launch {
            repository.getTeamById(Constants.TEAM_ID).fold(
                onSuccess = { team ->
                    teamData = team
                    displayTeamInfo(team)
                    showLoading(false)
                },
                onFailure = { error ->
                    showLoading(false)
                    showError(error.message ?: "Unknown error occurred")
                }
            )
        }
    }

    private fun displayTeamInfo(team: TeamResponse) {
        // Display club name
        binding.tvClubName.text = team.name

        // Load club logo
        Glide.with(this)
            .load(team.crest)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(binding.ivClubLogo)

        // Display club description
        val description = buildString {
            append(team.name)
            team.founded?.let { append(", founded in $it") }
            team.venue?.let { append(". Home stadium: $it") }
            team.clubColors?.let { append(". Club colors: $it") }
        }
        binding.tvClubDescription.text = description
    }

    private fun setupClickListeners() {
        binding.cardHistory.setOnClickListener {
            val intent = Intent(this, ClubHistoryActivity::class.java)
            startActivity(intent)
        }

        binding.cardCoach.setOnClickListener {
            if (teamData?.coach != null) {
                val coach = teamData?.coach!!
                val intent = Intent(this, CoachActivity::class.java).apply {
                    putExtra("COACH_NAME", coach.name ?: "Unknown")
                    putExtra("COACH_NATIONALITY", coach.nationality ?: "Unknown")
                    putExtra("COACH_DOB", coach.dateOfBirth ?: "Unknown")
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Coach data not available", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cardSquad.setOnClickListener {
            val squad = teamData?.squad
            if (!squad.isNullOrEmpty()) {
                val intent = Intent(this, SquadActivity::class.java).apply {
                    putParcelableArrayListExtra("SQUAD_LIST", ArrayList<Player>(squad))
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Squad data not available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showError(message: String) {
        Toast.makeText(this, "Error: $message", Toast.LENGTH_LONG).show()
    }
}