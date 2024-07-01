package com.deaddev.practiceapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.deaddev.practiceapp.R
import com.deaddev.practiceapp.databinding.FragmentInputFormBinding
import com.google.android.material.snackbar.Snackbar

class InputFormFragment : Fragment(R.layout.fragment_input_form) {
    private var binding: FragmentInputFormBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInputFormBinding.bind(view)

        binding?.run {
            button.setOnClickListener {
                val text = textInput.text.toString()
                if (text.isEmpty()) {
                    Snackbar.make(view, getString(R.string.no_text), Snackbar.LENGTH_LONG).show()
                } else {
                    findNavController().navigate(
                        resId = R.id.action_inputFormFragment_to_textDisplayFragment,
                        args = TextDisplayFragment.bundle(text),
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}