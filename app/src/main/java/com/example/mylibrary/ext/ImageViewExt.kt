package com.example.mylibrary.ext

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.load.resource.gif.GifDrawable.LOOP_FOREVER
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.mylibrary.R

fun ImageView.src(@DrawableRes id: Int) {
    Glide.with(this)
        .load(id)
        .into(this)
}

fun ImageView.src(url: String?) {
    Glide.with(this)
        .load(url)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
        )
        .into(this)
}

fun ImageView.srcGif(@DrawableRes res: Int, loopCount: Int = LOOP_FOREVER) {
    Glide.with(this)
        .asDrawable()
        .load(res)
        .error(R.drawable.ic_broken_image)
        .into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                resource as GifDrawable
                resource.setLoopCount(loopCount)
                resource.startFromFirstFrame()
                resource.start()
                setImageDrawable(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                setImageDrawable(placeholder)
            }
        })
}
