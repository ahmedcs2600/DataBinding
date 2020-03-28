package com.example.practice.network

import com.example.practice.models.Project
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {

    companion object{
        const val HTTPS_API_GITHUB_URL = "https://api.github.com/"
    }

    @GET("users/{user}/repos")
    fun getProjectList(@Path("user") user: String): Call<List<Project>>

    @GET("/repos/{user}/{reponame}")
    fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Call<Project>
}