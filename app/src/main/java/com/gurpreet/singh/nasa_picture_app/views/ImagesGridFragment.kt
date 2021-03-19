package com.gurpreet.singh.nasa_picture_app.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gurpreet.singh.nasa_picture_app.R
import com.gurpreet.singh.nasa_picture_app.adapter.ImagesGridAdapter
import com.gurpreet.singh.nasa_picture_app.data.ImageData
import com.gurpreet.singh.nasa_picture_app.databinding.FragmentImagesGridBinding
import com.gurpreet.singh.nasa_picture_app.view_model.ImagesGridViewModel

class ImagesGridFragment : Fragment() {
    private lateinit var viewModel: ImagesGridViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentImagesGridBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_images_grid, container, false)

        val adapter = ImagesGridAdapter(ImagesGridAdapter.ImageClickListener { imageData ->

            Toast.makeText(context, "clicked $imageData", Toast.LENGTH_SHORT).show()
            findNavController().navigate(ImagesGridFragmentDirections
                .actionImagesGridFragmentToImageDetailsFragment(imageData, viewModel.imagesList.value!!.toTypedArray()))
        })

        binding.nasaImagesRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(ImagesGridViewModel::class.java)

        viewModel.imagesList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        return binding.root
    }

}