package com.deaddev.practiceapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.deaddev.practiceapp.R
import com.deaddev.practiceapp.cats.CatsRepository
import com.deaddev.practiceapp.databinding.FragmentCatsMenuBinding
import com.deaddev.practiceapp.recycler.CatsViewAdapter

class CatsMenuFragment : Fragment(R.layout.fragment_cats_menu) {
    private var binding: FragmentCatsMenuBinding? = null
    private var adapter: CatsViewAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatsMenuBinding.bind(view)
        binding?.run {
            adapter = CatsViewAdapter(source = CatsRepository.cats,
                glide = Glide.with(this@CatsMenuFragment),
                onClick = {
                    findNavController().navigate(
                        resId = R.id.action_catsMenuFragment_to_catAdvancedFragment,
                        args = CatAdvancedFragment.bundle(context, it.id),
                    )
                })

            rvCatsList.adapter = adapter
            rvCatsList.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}