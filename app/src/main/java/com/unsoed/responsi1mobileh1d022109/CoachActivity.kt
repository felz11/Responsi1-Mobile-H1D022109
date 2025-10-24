package com.unsoed.responsi1mobileh1d022109

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.unsoed.responsi1mobileh1d022109.databinding.ActivityCoachBinding

class CoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Head Coach"

        displayCoachInfo()
    }

    private fun displayCoachInfo() {
        val coachName = intent.getStringExtra("COACH_NAME") ?: "Unknown"
        val coachNationality = intent.getStringExtra("COACH_NATIONALITY") ?: "Unknown"
        val coachDob = intent.getStringExtra("COACH_DOB") ?: "Unknown"

        binding.tvCoachName.text = coachName
        binding.tvCoachNationality.text = coachNationality
        binding.tvCoachDob.text = coachDob
        // Try to load drawable named alexander_blessin from res/drawable; fallback to ic_launcher
        val resId = resources.getIdentifier("alexander_blessin", "drawable", packageName)
        val imageSource = if (resId != 0) resId else R.mipmap.ic_launcher
        Glide.with(this)
            .load(imageSource)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(binding.ivCoachPhoto)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}