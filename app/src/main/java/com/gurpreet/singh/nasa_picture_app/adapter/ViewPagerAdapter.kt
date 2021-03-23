package com.gurpreet.singh.nasa_picture_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gurpreet.singh.nasa_picture_app.R
import com.gurpreet.singh.nasa_picture_app.data.ImageData
import kotlinx.android.synthetic.main.layout_image_details_item.view.*

class ViewPagerAdapter(private val imageDataList: ArrayList<ImageData>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    val noLicenceFound :String  = "No Licence"
    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_image_details_item, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        var currentImageData = imageDataList[position]
        holder.itemView.title.text = currentImageData.title
        holder.itemView.date.text = currentImageData.date
        holder.itemView.explanation.text = currentImageData.explanation
        holder.itemView.hd_image.loadImageFromUrl(currentImageData.hdurl)

        if(currentImageData.copyright == null) holder.itemView.copyright.text = noLicenceFound else{
            holder.itemView.copyright.text = currentImageData.copyright
        }
    }

    override fun getItemCount(): Int {
        return imageDataList.size
    }
}