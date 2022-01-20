package com.example.unofficial_twicas_client_for_android

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("broadcasterName")
fun TextView.setBroadcasterName(item: RecommendMovieProperty) {
    text = item.broadcaster.name
}

@BindingAdapter("movieThumbnail")
fun ImageView.setSmallThumbnail(item: RecommendMovieProperty) {
    item.movie.small_thumbnail?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(this.context)
            .load(imgUri)
            .into(this)
    }
}

@BindingAdapter("broadcaster_image")
fun ImageView.setBroadcasterImage(item: RecommendMovieProperty) {
    item.broadcaster.image?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(this.context)
            .load(imgUri)
            .into(this)
    }
}

@BindingAdapter("broadcaster_id")
fun TextView.setBroadcasterId(item: RecommendMovieProperty) {
    text = item.broadcaster.screen_id
}

@BindingAdapter("movie_title")
fun TextView.setMovieTitle(item: RecommendMovieProperty) {
    text = item.movie.title
}

@BindingAdapter("movie_current_view_count")
fun TextView.setMovieCurrentViewCount(item: RecommendMovieProperty) {
    text = item.movie.current_view_count.toString()
}

@BindingAdapter("movie_comment_count")
fun TextView.setMovieCommentCount(item: RecommendMovieProperty) {
    text = item.movie.comment_count.toString()
}











