/*
 *
 *  * @copyright : Nexus App Developers. < https://www.nexusappdevelopers.com >
 *  * @author     : Elliot
 *  *
 *  * All Rights Reserved.
 *  * Proprietary and confidential :  All information contained herein is, and remains
 *  * the property of Nexus App Developers and its partners.
 *  * Unauthorized copying of this file, via any medium is strictly prohibited.
 *
 */

package com.nexus.codebase.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nexus.codebase.R
import com.nexus.codebase.model.Song


class SongAdapter(private var Songs: List<Song>) :
    RecyclerView.Adapter<SongAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_song, parent, false)
        return MViewHolder(view)
    }

    override fun onBindViewHolder(vh: MViewHolder, position: Int) {
        vh.bind(Songs[position])
    }

    override fun getItemCount(): Int {
        return Songs.size
    }

    fun update(data: List<Song>) {
        Songs = data
        notifyDataSetChanged()
    }

    class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textViewName: TextView = view.findViewById(R.id.textViewName)
        private val imageView: ImageView = view.findViewById(R.id.imageView)
        fun bind(Song: Song) {
            textViewName.text = Song.name.capitalize()
            Glide.with(imageView.context).load(Song.photo).into(imageView)
        }
    }
}