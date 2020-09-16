package com.fathansatria.pagination3sample.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.fathansatria.pagination3sample.utils.glide.GlideApp


@BindingAdapter("setImageUrl")
fun AppCompatImageView.setImageUrl(imageUrl: String?) {
    GlideApp.with(this)
        .load(imageUrl)
        .into(this)
}