package com.example.unofficial_twicas_client_for_android

data class Movies(
    val movies: List<RecommendMovieProperty>
)

data class RecommendMovieProperty(
    val movie: Movie,
    val broadcaster: Broadcaster,
    val tags: List<String>
)

data class Movie(
    val id: String,
    val user_id: String,
    val title: String,
    val subtitle: String?,
    val last_owner_comment: String?,
    val category: String?,
    val link: String,
    val is_live: Boolean,
    val is_recorded: Boolean,
    val comment_count: Int,
    val large_thumbnail: String,
    val small_thumbnail: String,
    val country: String,
    val duration: Int,
    val created: Int,
    val is_collabo: Boolean,
    val is_protected: Boolean,
    val max_view_count: Int,
    val current_view_count: Int,
    val total_view_count: Int,
    val hls_url: String?
)

data class Broadcaster(
    val id: String,
    val screen_id: String,
    val name: String,
    val image: String,
    val profile: String,
    val level: Int,
    val last_movie_id: String?,
    val is_live: Boolean,
    val supporter_count: Int,
    val supporting_count: Int,
    val created: Int
)


