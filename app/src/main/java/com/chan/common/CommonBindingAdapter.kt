package com.chan.common

import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chan.ui.detail.ProductDetailViewModel
import com.chan.ui.home.model.ProductModel
import com.chan.ui.home.viewmodel.HomeViewModel
import java.text.DecimalFormat

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T?) {
    if (recyclerView.adapter is BindListAdapter<*>) {
        (recyclerView.adapter as BindListAdapter<T>).addAllData(data)
    }
}

@BindingAdapter("bindImage")
fun setBindImage(
    view: ImageView,
    imgUrl: String
) {
    Glide.with(view.context)
        .load(imgUrl)
        .thumbnail(1.0f)
        .into(view)
}

@BindingAdapter("textWon")
fun setTextWon(
    textView: TextView,
    price: Int
) {
    val formatter = DecimalFormat("###,###.##원")
    textView.text = formatter.format(price)
}

@BindingAdapter("isBookmark", "productModel")
fun setBookmark(toggleButton: ToggleButton, viewModel: ViewModel, productModel: ProductModel) {
    if (viewModel is HomeViewModel) {
        viewModel.isBookMark(toggleButton.context, productModel, onResult = {
            toggleButton.isChecked = it
        })
    } else if (viewModel is ProductDetailViewModel) {
        viewModel.isBookMark(toggleButton.context, productModel, onResult = {
            toggleButton.isChecked = it
        })
    }
}