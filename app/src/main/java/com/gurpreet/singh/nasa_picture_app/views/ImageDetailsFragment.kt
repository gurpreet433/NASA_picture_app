package com.gurpreet.singh.nasa_picture_app.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.gurpreet.singh.nasa_picture_app.R
import com.gurpreet.singh.nasa_picture_app.databinding.FragmentImageDetailsBinding
import com.gurpreet.singh.nasa_picture_app.view_model.ImageDetailsViewModel

class ImageDetailsFragment : Fragment() {
    private val args: ImageDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: ImageDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentImageDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_image_details, container, false)

        binding.imageData = args.imageData

        viewModel = ViewModelProvider(this).get(ImageDetailsViewModel::class.java)

        return binding.root
    }

}