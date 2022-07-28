package com.example.movieapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.data.Movie
import com.example.movieapp.R

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private var movies: List<Movie> = emptyList()

    fun fillMovies(list: List<Movie>) {
        this.movies = list
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.ivMovie)
        val movieTitle: TextView = itemView.findViewById(R.id.tvMovieTitle)
        val movieDescription: TextView = itemView.findViewById(R.id.tvMovieDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerview_movie_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].display_title
        holder.movieDescription.text = movies[position].summary_short

        Glide
            .with(holder.itemView.context)
            .load(movies[position].multimedia.src)
            .into(holder.movieImage)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}