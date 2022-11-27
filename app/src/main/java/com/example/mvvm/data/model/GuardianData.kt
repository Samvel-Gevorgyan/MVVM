package com.example.mvvm.data.model

import com.google.gson.annotations.SerializedName

data class GuardianNewsData(
    @SerializedName("response")
    val response: GuardianNewsResponse?
)

data class GuardianNewsResponse(
    @SerializedName("currentPage")
    val currentPage: Int?,
    @SerializedName("orderBy")
    val orderBy: String?,
    @SerializedName("pageSize")
    val pageSize: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("results")
    val results: List<GuardianNewsResult>?,
    @SerializedName("startIndex")
    val startIndex: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("userTier")
    val userTier: String?
)

data class GuardianNewsResult(
    @SerializedName("apiUrl")
    val apiUrl: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isHosted")
    val isHosted: Boolean?,
    @SerializedName("pillarId")
    val pillarId: String?,
    @SerializedName("pillarName")
    val pillarName: String?,
    @SerializedName("sectionId")
    val sectionId: String?,
    @SerializedName("sectionName")
    val sectionName: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("webPublicationDate")
    val webPublicationDate: String?,
    @SerializedName("webTitle")
    val webTitle: String?,
    @SerializedName("webUrl")
    val webUrl: String?
)