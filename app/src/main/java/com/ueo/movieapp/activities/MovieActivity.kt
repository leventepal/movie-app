package com.ueo.movieapp.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ueo.movieapp.R
import com.ueo.movieapp.networking.MovieAPIService
import com.ueo.movieapp.networking.model.Movie
import com.ueo.movieapp.networking.model.SearchResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieActivity : AppCompatActivity() {

    companion object {
        private const val API_KEY = "203d01a5388c1c68afb9da0915bae462"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        setupNetworking()
    }

    private fun setupNetworking() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/")
            .build()

        val movieApiService = retrofit.create(MovieAPIService::class.java)

//        movieApiService.getMovieDetail(550, API_KEY)
//            .enqueue(object : Callback<Movie> {
//                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
//                    System.currentTimeMillis()
//                }
//
//                override fun onFailure(call: Call<Movie>, t: Throwable) {
//                    System.currentTimeMillis()
//                }
//            })

        movieApiService.searchMovies(API_KEY, "en-US", 1, "endgame")
            .enqueue(object : Callback<SearchResult> {
                override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                    response.body()?.results?.firstOrNull()?.let { movie ->
                        showMovieDetails(movie)
                    }
                }

                override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                    System.currentTimeMillis()
                }
            })
    }

    private fun showMovieDetails(movie: Movie) {
        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val ivImage = findViewById<ImageView>(R.id.iv_poster)
        val tvDescription = findViewById<TextView>(R.id.tv_description)

        tvTitle.setText(movie.title)
        tvDescription.setText(movie.overview)

        movie.posterPath?.let { poster ->
            String.format("https://image.tmdb.org/t/p/w500/%s", poster).let { imageLink ->
                Glide.with(this)
                    .load(imageLink)
                    .into(ivImage)
            }
        }
    }

}