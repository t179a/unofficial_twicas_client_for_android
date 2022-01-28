package com.example.unofficial_twicas_client_for_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.MimeTypes
import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.graphics.Rect
import android.util.Rational
import android.view.View
import com.example.unofficial_twicas_client_for_android.databinding.ActivityMovieBinding


class MovieActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate((layoutInflater))

        val recommendMovieProperty: RecommendMovieProperty = intent.getSerializableExtra("recommendMovieProperty") as RecommendMovieProperty

        //Toast.makeText(this, recommendMovieProperty.toString(), Toast.LENGTH_SHORT).show()

        val player = ExoPlayer.Builder(applicationContext).build().also {exoPlayer ->
            binding.playerView.player = exoPlayer
            val mediaItem:MediaItem= MediaItem.Builder()
                .setUri(recommendMovieProperty.movie.hls_url).setMimeType(MimeTypes.APPLICATION_M3U8)
                .build()
            //Toast.makeText(applicationContext, recommendMovieProperty.movie.hls_url.toString(), Toast.LENGTH_SHORT).show()
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.play()
        }

        binding.topAppBar.setOnClickListener {
            player.release()
            finish()
        }

        setContentView(binding.root)

        setPictureInPictureParams(
            PictureInPictureParams.Builder()
                .setAutoEnterEnabled(true)
                .build()
        )
    }






    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration?
    ) {
        if(isInPictureInPictureMode){
            binding.topAppBar.visibility = View.GONE
            binding.commentView.visibility = View.GONE
        }else{
            binding.topAppBar.visibility = View.VISIBLE
            binding.commentView.visibility = View.VISIBLE

        }
    }
}