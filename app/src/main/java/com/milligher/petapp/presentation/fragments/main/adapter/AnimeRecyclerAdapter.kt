package com.milligher.petapp.presentation.fragments.main.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.milligher.petapp.R
import com.milligher.petapp.domain.model.api.Anime
import com.milligher.petapp.presentation.activities.detail.DetailActivity

class AnimeRecyclerAdapter: RecyclerView.Adapter<AnimeRecyclerAdapter.VH>() {

    private lateinit var context: Context
    private var animeList: MutableList<Anime> = mutableListOf()

    class VH (itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.anime_item_name)
        val image: ImageView = itemView.findViewById(R.id.anime_item_image)
        val animeItem: CardView = itemView.findViewById(R.id.anime_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.anime_recycler_item, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val listItem = animeList[position]

        holder.name.text = listItem.title
        Glide.with(context)
            .load(listItem.images.jpg.image_url)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.image)

        holder.animeItem.setOnClickListener {
            Log.d("MYTAG", listItem.title)
            openDetailActivity(listItem.mal_id)
        }
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    fun setAnimeList(list: List<Anime>){
        animeList.addAll(list)
        notifyDataSetChanged()
    }

    private fun openDetailActivity(id: Int) {
        val intent = DetailActivity.newIntent(context = context, id = id)
        context.startActivity(intent)
    }
}