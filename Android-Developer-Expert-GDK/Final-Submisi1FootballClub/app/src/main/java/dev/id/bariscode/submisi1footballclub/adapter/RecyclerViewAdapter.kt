package dev.id.bariscode.submisi1footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import dev.id.bariscode.submisi1footballclub.`object`.FootballClub
import dev.id.bariscode.submisi1footballclub.R

class RecyclerViewAdapter(
    private val context: Context,
    private val footballClub: List<FootballClub>,
    private val listener: (FootballClub) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_footballclub, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindClubFootball(footballClub[position], listener)
    }

    override fun getItemCount(): Int = footballClub.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val namaClubfootball = view.findViewById<TextView>(R.id.NamaClub)
        private val descClubfootball = view.findViewById<TextView>(R.id.DeskripsiClub)
        private val logoClubfootball = view.findViewById<ImageView>(R.id.LogoClub)

        fun bindClubFootball(footballClub: FootballClub, listener: (FootballClub) -> Unit) {
            namaClubfootball.text = footballClub.namaClub
            descClubfootball.text = footballClub.deskripsiClub

            footballClub.gambarClub?.let { Picasso.get().load(it).into(logoClubfootball) }

            itemView.setOnClickListener {
                listener(footballClub)
            }
        }
    }
}