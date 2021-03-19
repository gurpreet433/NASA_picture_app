package com.gurpreet.singh.nasa_picture_app.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.gurpreet.singh.nasa_picture_app.R
import com.gurpreet.singh.nasa_picture_app.adapter.ViewPagerAdapter
import com.gurpreet.singh.nasa_picture_app.data.ImageData
import com.gurpreet.singh.nasa_picture_app.databinding.FragmentImageDetailsBinding
import com.gurpreet.singh.nasa_picture_app.factory.ImageDetailsViewModelFactory
import com.gurpreet.singh.nasa_picture_app.view_model.ImageDetailsViewModel

class ImageDetailsFragment : Fragment() {
    private val args: ImageDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: ImageDetailsViewModel
    private lateinit var viewModelFactory: ImageDetailsViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentImageDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_image_details, container, false)

        val adapter = ViewPagerAdapter ( args.imageDataList.toCollection(ArrayList()))
        binding.viewPager.adapter = adapter
      // set view pager position

        viewModelFactory = ImageDetailsViewModelFactory(args.imageData, args.imageDataList.toCollection(ArrayList()))
        viewModel = ViewModelProvider(this, viewModelFactory).get(ImageDetailsViewModel::class.java)

        return binding.root
    }

}