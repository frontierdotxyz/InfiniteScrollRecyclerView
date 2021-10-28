package com.frontier.infinitescrollrecyclerview.layoutmanager

import android.content.Context
import android.util.DisplayMetrics
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

class AutoScrollHorizontalGridLayoutManager(val context: Context, val scrollSpeed: Float) :
    GridLayoutManager(context, 4, RecyclerView.HORIZONTAL, false) {
    override fun smoothScrollToPosition(
        recyclerView: RecyclerView,
        state: RecyclerView.State,
        position: Int
    ) {
        val smoothScroller: LinearSmoothScroller = object :
            LinearSmoothScroller(context) {
            private val SPEED = scrollSpeed // Change this value (default=25f)
            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                return SPEED / displayMetrics.densityDpi
            }
        }
        smoothScroller.targetPosition = position
        startSmoothScroll(smoothScroller)
    }
}
