package com.example.practice.network

import com.example.practice.models.Project
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface WebService {

    companion object{
        const val HTTPS_API_GITHUB_URL = "https://api.github.com/"
    }

    @GET("users/{user}/repos")
    fun getProjectList(@Path("user") user: String): Single<List<Project>>

    @GET("/repos/{user}/{reponame}")
    fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String?): Single<Project>
}