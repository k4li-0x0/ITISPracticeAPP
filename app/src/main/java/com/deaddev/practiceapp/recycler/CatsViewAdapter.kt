package com.deaddev.practiceapp.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.deaddev.practiceapp.cats.CatBreedInfo
import com.deaddev.practiceapp.databinding.ItemCatShortCardBinding

class CatsViewAdapter(
    private var source: Array<CatBreedInfo>,
    private val glide: RequestManager,
    private val onClick: (CatBreedInfo) -> Unit,
) : RecyclerView.Adapter<CatsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CatsViewHolder = CatsViewHolder(
        binding = ItemCatShortCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide, onClick = onClick
    )

    override fun getItemCount(): Int = source.size

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        holder.onBind(source[position])
    }
}