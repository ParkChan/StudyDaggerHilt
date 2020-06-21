package com.chan.ui.bookmark.repository

import android.content.Context
import com.chan.ui.bookmark.BookmarkSortType
import com.chan.ui.bookmark.local.BookmarkDataSource
import com.chan.ui.bookmark.model.BookmarkModel
import com.chan.ui.home.model.ProductModel
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class BookmarkRepository @Inject constructor(
    private val bookmarkDataSource: BookmarkDataSource
) {

    fun selectAll(
        context: Context,
        sort: BookmarkSortType,
        onSuccess: (list: List<BookmarkModel>) -> Unit,
        onFail: (error: String) -> Unit
    ): Disposable = bookmarkDataSource.selectAll(
        context,
        sort,
        onSuccess,
        onFail
    )

    fun selectExists(
        context: Context,
        productModel: ProductModel,
        result: (exists: Boolean) -> Unit
    ): Disposable =
        bookmarkDataSource.selectExists(context, productModel, result)


    fun insertBookMark(context: Context, model: ProductModel): Disposable =
        bookmarkDataSource.insertBookMark(context, convertToBookMarkModel(model))

    fun deleteBookMark(context: Context, model: ProductModel): Disposable =
        bookmarkDataSource.deleteBookMark(context, convertToBookMarkModel(model))

    fun deleteBookMark(context: Context, model: BookmarkModel): Disposable =
        bookmarkDataSource.deleteBookMark(context, model)

    private fun convertToBookMarkModel(model: ProductModel): BookmarkModel {
        return BookmarkModel(
            id = model.id,
            name = model.name,
            thumbnail = model.thumbnail,
            imagePath = model.descriptionModel.imagePath,
            subject = model.descriptionModel.subject,
            price = model.descriptionModel.price,
            rate = model.rate,
            regTimeStamp = System.currentTimeMillis()
        )
    }

}