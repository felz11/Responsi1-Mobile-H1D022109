package com.unsoed.responsi1mobileh1d022109.data.repository

import com.unsoed.responsi1mobileh1d022109.data.model.TeamResponse
import com.unsoed.responsi1mobileh1d022109.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamRepository(private val apiService: ApiService) {

    suspend fun getTeamById(teamId: Int): Result<TeamResponse> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getTeamById(teamId)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}