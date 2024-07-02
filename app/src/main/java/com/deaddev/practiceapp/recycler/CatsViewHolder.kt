package com.deaddev.practiceapp.recycler

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.deaddev.practiceapp.R
import com.deaddev.practiceapp.cats.CatBreedInfo
import com.deaddev.practiceapp.databinding.ItemCatShortCardBinding

class CatsViewHolder(
    private val binding: ItemCatShortCardBinding,
    private val glide: RequestManager,
    private val onClick: (CatBreedInfo) -> Unit
) : ViewHolder(binding.root) {
    private val requestOptions = RequestOptions.diskCacheStrategyOf(
        DiskCacheStrategy.ALL
    )
    private val context: Context = itemView.context

    fun onBind(info: CatBreedInfo) {
        binding.run {
            tvItemTitle.text = context.getString(info.breed.get_name_id())
            val description = context.getString(info.breed.get_description_id())
            tvItemShortDescription.text = binding.root.context.getString(
                R.string.read_more,
                description.take(50)
            )
            glide
                .load(info.imageUrl)
                .error(R.drawable.baseline_broken_image_24)
                .placeholder(R.drawable.baseline_pets_24)
                .apply(requestOptions)
                .into(ivItemIconSmall)
            root.setOnClickListener {
                onClick.invoke(info)
            }
        }
    }
}