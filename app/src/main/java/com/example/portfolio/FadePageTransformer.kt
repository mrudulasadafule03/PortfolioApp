package com.example.portfolio

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class FadePageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            alpha = 1 - kotlin.math.abs(position)    // Fade in/out
            translationX = -position * page.width   // Keep normal slide
            pivotX = 0f
            pivotY = 0f
        }
    }
}
