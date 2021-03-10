package com.example.dicodinsubmission

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodinsubmission.model.Mod

class MainAdapter(private val context: Context) : ListAdapter<Mod, MainAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_mod, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.textView_name)
        val status = view.findViewById<TextView>(R.id.textView_status)
        val details = view.findViewById<TextView>(R.id.textView_details)
        val background = view.findViewById<ImageView>(R.id.imageView_mod)
        val cardView_root = view.findViewById<CardView>(R.id.cardView_root)

        fun bind(mod: Mod) {
            Glide.with(view).load(mod.image).into(background)

            name.text = mod.name
            status.text = "${mod.status} ${mod.year} ${mod.genre}"
            details.text = mod.details

            cardView_root.setOnClickListener{
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.MODS, mod)
                context.startActivity(intent)

            }
        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<Mod>() {
    override fun areItemsTheSame(oldItem: Mod, newItem: Mod): Boolean = oldItem == newItem


    override fun areContentsTheSame(oldItem: Mod, newItem: Mod): Boolean = oldItem.name == newItem.name


}

