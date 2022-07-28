package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(
    private val loadNextPage: () -> Unit
) : ListAdapter<Movie, MovieAdapter.MyViewHolder>(MovieDiffUtil) {

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
        val movie = getItem(position)
        holder.movieTitle.text = movie.displayTitle
        holder.movieDescription.text = movie.summaryShort

        Glide
            .with(holder.itemView.context)
            .load(movie.multimedia.imageUrl)
            .into(holder.movieImage)

        if (position == itemCount - 2) {
            loadNextPage()
        }
    }

    object MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.displayTitle == newItem.displayTitle
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.summaryShort == newItem.summaryShort &&
                oldItem.multimedia == newItem.multimedia
        }
    }
}