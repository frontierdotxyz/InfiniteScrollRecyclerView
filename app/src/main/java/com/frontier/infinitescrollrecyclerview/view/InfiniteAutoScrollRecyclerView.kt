package com.frontier.infinitescrollrecyclerview.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.frontier.infinitescrollrecyclerview.R
import com.frontier.infinitescrollrecyclerview.adapter.InfiniteAutoScrollAdapter
import com.frontier.infinitescrollrecyclerview.extensions.getGridHorizontalMarginDecoration
import com.frontier.infinitescrollrecyclerview.extensions.getListHorizontalMarginDecoration
import com.frontier.infinitescrollrecyclerview.layoutmanager.AutoScrollHorizontalGridLayoutManager
import com.frontier.infinitescrollrecyclerview.layoutmanager.AutoScrollHorizontalListLayoutManager

const val DEFAULT_SCROLL_SPEED = 35000f
const val DEFAULT_ITEM_MARGIN = 12

class InfiniteAutoScrollRecyclerView : RecyclerView {

    private lateinit var infiniteAutoScrollAdapter: InfiniteAutoScrollAdapter
    private var itemLeftMargin = DEFAULT_ITEM_MARGIN
    private var itemRightMargin = DEFAULT_ITEM_MARGIN
    private var itemTopMargin = DEFAULT_ITEM_MARGIN
    private var itemBottomMargin = DEFAULT_ITEM_MARGIN

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr,
    ) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes =
                context.obtainStyledAttributes(
                    attributeSet,
                    R.styleable.InfiniteAutoScrollRecyclerView
                )
            val scrollOrientation = attributes.getInteger(
                R.styleable.InfiniteAutoScrollRecyclerView_scrollOrientation,
                HORIZONTAL
            )
            val scrollLayoutType = attributes.getInteger(
                R.styleable.InfiniteAutoScrollRecyclerView_scrollLayoutType,
                ScrollLayoutType.GRID
            )
            itemLeftMargin = attributes.getInteger(
                R.styleable.InfiniteAutoScrollRecyclerView_itemLeftMargin,
                DEFAULT_ITEM_MARGIN
            )
            itemTopMargin = attributes.getInteger(
                R.styleable.InfiniteAutoScrollRecyclerView_itemTopMargin,
                DEFAULT_ITEM_MARGIN
            )

            itemRightMargin = attributes.getInteger(
                R.styleable.InfiniteAutoScrollRecyclerView_itemRightMargin,
                DEFAULT_ITEM_MARGIN
            )
            itemBottomMargin = attributes.getInteger(
                R.styleable.InfiniteAutoScrollRecyclerView_itemBottomMargin,
                DEFAULT_ITEM_MARGIN
            )

            setAutoScrollAdapter(
                scrollOrientation = scrollOrientation,
                scrollLayoutType = scrollLayoutType
            )
            attributes.recycle()
        }
    }

    private fun setAutoScrollAdapter(
        scrollOrientation: Int,
        scrollLayoutType: Int
    ) {
        val evenLayoutResId = getEvenLayoutRes(scrollLayoutType, scrollOrientation)
        infiniteAutoScrollAdapter = InfiniteAutoScrollAdapter(evenLayoutResId = evenLayoutResId)
        layoutManager = getLayoutManager(scrollLayoutType)
        adapter = infiniteAutoScrollAdapter
        addItemDecoration(getItemDecoration(scrollLayoutType, scrollOrientation))
    }

    private fun getItemDecoration(scrollLayoutType: Int, scrollOrientation: Int) =
        if (scrollLayoutType == ScrollLayoutType.LIST && scrollOrientation == HORIZONTAL) {
            context.getListHorizontalMarginDecoration(leftMargin = itemLeftMargin, topMargin = itemTopMargin, rightMargin = itemRightMargin, bottomMargin = itemBottomMargin)
        } else if (scrollLayoutType == ScrollLayoutType.GRID && scrollOrientation == HORIZONTAL) {
            context.getGridHorizontalMarginDecoration()
        } else {
            context.getGridHorizontalMarginDecoration()
        }

    private fun getLayoutManager(scrollLayoutType: Int) =
        when (scrollLayoutType) {
            ScrollLayoutType.LIST -> AutoScrollHorizontalListLayoutManager(
                context,
                DEFAULT_SCROLL_SPEED
            )
            ScrollLayoutType.GRID -> AutoScrollHorizontalGridLayoutManager(
                context,
                DEFAULT_SCROLL_SPEED
            )
            else -> throw IllegalArgumentException("Illegal Scroll Type")
        }

    private fun getEvenLayoutRes(scrollLayoutType: Int, scrollOrientation: Int) =
        if (scrollLayoutType == ScrollLayoutType.LIST && scrollOrientation == HORIZONTAL) {
            R.layout.item_infinite_scroll_list_horizontal
        } else if (scrollLayoutType == ScrollLayoutType.GRID && scrollOrientation == HORIZONTAL) {
            R.layout.item_infinite_scroll_grid_horizontal
        } else {
            R.layout.item_infinite_scroll_list_horizontal
        }

    fun startScrolling(images: List<Int>) {
        infiniteAutoScrollAdapter.notifyData(images)
        post {
            smoothScrollToPosition(Int.MAX_VALUE - 1)
        }
    }

    object ScrollLayoutType {
        const val LIST = 1
        const val GRID = 2
    }
}