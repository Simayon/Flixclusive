package com.flixclusive_provider.models.common
data class SearchResults(
    val currentPage: Int = 1,
    val hasNextPage: Boolean = false,
    val results: List<SearchResultItem> = emptyList()
)