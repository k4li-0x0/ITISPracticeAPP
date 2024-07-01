package com.deaddev.practiceapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.deaddev.practiceapp.R
import com.deaddev.practiceapp.databinding.FragmentTextDisplayBinding

class TextDisplayFragment : Fragment(R.layout.fragment_text_display) {
    private var binding: FragmentTextDisplayBinding? = null

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTextDisplayBinding.bind(view)
        val text = arguments?.getString(ARG_TEXT) ?: "Failed"
        binding?.run {
            textDosplayView.text = text
        }
    }

    companion object {
        private const val ARG_TEXT = ""
        fun bundle(text: String): Bundle = Bundle().apply {
            putString(ARG_TEXT, text)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}