package com.gurpreet.singh.nasa_picture_app.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gurpreet.singh.nasa_picture_app.R
import com.gurpreet.singh.nasa_picture_app.databinding.FragmentImagesGridBinding

class ImagesGridFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentImagesGridBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_images_grid, container, false)

        return binding.root
    }

}