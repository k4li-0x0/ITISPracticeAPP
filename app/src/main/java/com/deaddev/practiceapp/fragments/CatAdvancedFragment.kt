package com.deaddev.practiceapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.deaddev.practiceapp.R
import com.deaddev.practiceapp.databinding.FragmentCatAdvancedBinding
import com.deaddev.practiceapp.cats.CatsRepository

class CatAdvancedFragment : Fragment(R.layout.fragment_cat_advanced) {
    private var binding: FragmentCatAdvancedBinding? = null
    private val requestOptions = RequestOptions.diskCacheStrategyOf(
        DiskCacheStrategy.ALL
    )
    private var glide: RequestManager? = null

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatAdvancedBinding.bind(view)
        glide = Glide.with(this@CatAdvancedFragment)
        binding?.run {
            val url = arguments?.getString(ARG_URL)
            glide?.load(url)
                ?.error(R.drawable.baseline_broken_image_24)
                ?.placeholder(R.drawable.baseline_pets_24)?.apply(requestOptions)
                ?.into(ivCatImage)
            tvBreedName.text = arguments?.getString(ARG_NAME)
            tvBreedDescription.text = arguments?.getString(ARG_DESCRIPTION)
            tvMaxAge.text = getString(
                R.string.age_range,
                arguments?.getInt(ARG_MAX_AGE_START),
                arguments?.getInt(ARG_MAX_AGE_END)
            )

            fabGoBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    companion object {
        private const val ARG_URL = "URL"
        private const val ARG_NAME = "NAME"
        private const val ARG_DESCRIPTION = "DESCRIPTION"
        private const val ARG_MAX_AGE_START = "AGE_START"
        private const val ARG_MAX_AGE_END = "AGE_END"
        fun bundle(context: Context?, cat_id: Int): Bundle = Bundle().apply {
            val cat = CatsRepository.cats.find { it.id == cat_id }
            if (cat != null) {
                putString(ARG_URL, cat.imageUrl)
                putString(ARG_NAME, context?.getString(cat.breed.get_name_id()))
                putString(ARG_DESCRIPTION, context?.getString(cat.breed.get_description_id()))
                putInt(ARG_MAX_AGE_END, cat.max_age.last)
                putInt(ARG_MAX_AGE_START, cat.max_age.first)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}