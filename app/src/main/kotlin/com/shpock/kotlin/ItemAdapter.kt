package com.shpock.kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*

/**
 * Created by Daniel Niedermühlbichler on 04/04/16.
 */
class ItemAdapter(val context: Context, val items: Array<Item> = arrayOf()) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        holder?.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder? {
        return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount() = items.size

}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Item) {
        itemView.title.text = item.title
        itemView.price.text = "${item.price}"

        loadSomeBeautifulImage()
    }

    private fun loadSomeBeautifulImage() {
        val width = (Math.random() * 100 + 500).toInt()
        val height = (Math.random() * 100 + 200).toInt()

        Glide.with(itemView.context)
                .load("http://placekitten.com/g/$width/$height")
                .into(itemView.previewImage)
    }

}