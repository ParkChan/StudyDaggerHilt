package com.chan.ui.home.remote

import com.chan.network.NETWORK_SUCCESS_CODE
import com.chan.network.api.GoodChoiceApi
import com.chan.ui.home.model.res.ResProductListModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchProductRemoteDataSource @Inject constructor(
    private val retrofit: GoodChoiceApi
) {
    fun searchProductList(
        page: Int,
        onSuccess: (githubInfo: ResProductListModel) -> Unit,
        onFail: (error: String) -> Unit
    ): Disposable = retrofit.getProductList(page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            val response = it.body()
            if (it.isSuccessful && response != null && response.code == NETWORK_SUCCESS_CODE) {
                onSuccess(response)
            } else {
                onFail(it.message())
            }
        }, {
            onFail(it.message.toString())
        })
}