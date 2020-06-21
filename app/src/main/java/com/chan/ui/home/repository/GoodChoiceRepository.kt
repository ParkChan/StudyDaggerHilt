package com.chan.ui.home.repository

import com.chan.ui.home.model.res.ResProductListModel
import com.chan.ui.home.remote.SearchProductRemoteDataSource
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class GoodChoiceRepository @Inject constructor(
    private val searchProductRemoteDataSource: SearchProductRemoteDataSource
) {
    fun requestData(
        page: Int,
        onSuccess: (resProductListModel: ResProductListModel) -> Unit,
        onFail: (error: String) -> Unit
    ): Disposable =
        searchProductRemoteDataSource.searchProductList(
            page,
            onSuccess,
            onFail
        )
}