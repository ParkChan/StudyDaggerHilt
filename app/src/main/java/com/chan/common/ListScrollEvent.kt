package com.chan.common

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

interface ListScrollEvent {
    fun onScrolled(visibleItemCount: Int, fistVisibleItem: Int, totalItemCount: Int)
}

fun setRecyclerViewScrollListener(
    recyclerView: RecyclerView,
    listScrollEvent: ListScrollEvent
) {
    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
    recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = layoutManager.childCount
            val fistVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
            val totalItemCount = layoutManager.itemCount

            listScrollEvent.run {
                onScrolled(
                    visibleItemCount,
                    fistVisibleItem,
                    totalItemCount
                )
            }
        }
    })
}