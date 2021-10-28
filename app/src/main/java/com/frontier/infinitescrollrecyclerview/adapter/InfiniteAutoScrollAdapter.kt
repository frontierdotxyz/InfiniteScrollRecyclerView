package com.frontier.infinitescrollrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.frontier.infinitescrollrecyclerview.R

class InfiniteAutoScrollAdapter(private val evenLayoutResId: Int) :
    RecyclerView.Adapter<InfiniteAutoScrollAdapter.InfiniteAutoScrollViewHolder>() {

    private var images = arrayListOf<Int>()

    fun notifyData(images: List<Int>) {
        this.images.clear()
        this.images.addAll(images)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): InfiniteAutoScrollViewHolder {
        return InfiniteAutoScrollViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(evenLayoutResId, viewGroup, false)
        )
    }

    override fun onBindViewHolder(holder: InfiniteAutoScrollViewHolder, position: Int) {
        holder.imageView.setImageResource(images[position % images.size])
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    class InfiniteAutoScrollViewHolder(@NonNull view: View) :
        RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.infiniteScrollImage)
    }
}