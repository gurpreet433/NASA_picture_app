package com.gurpreet.singh.nasa_picture_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gurpreet.singh.nasa_picture_app.data.ImageData
import com.gurpreet.singh.nasa_picture_app.databinding.GridImageItemBinding

class ImagesGridAdapter(val clickListener: ImageClickListener):
        androidx.recyclerview.widget.ListAdapter<ImageData, ImagesGridAdapter.ViewHolder>(ImageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(getItem(position), clickListener)
    }

    class ViewHolder private constructor(val binding: GridImageItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageData, clickListener: ImageClickListener) {
            binding.imageData = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GridImageItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class ImageDiffCallback : DiffUtil.ItemCallback<ImageData>() {
        override fun areItemsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
            return oldItem == newItem
        }
    }

    class ImageClickListener(val clickListener: (imageData: ImageData) -> Unit) {
        fun onClick(imageData: ImageData) =
                imageData.let {
                    clickListener(imageData)
                }
    }




}