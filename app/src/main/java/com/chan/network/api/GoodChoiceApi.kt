package com.chan.network.api

import com.chan.ui.home.model.res.ResProductListModel
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GoodChoiceApi {

    @GET("App/json/{page}.json")
    fun getProductList(
        @Path("page") page: Int
    ): Single<Response<ResProductListModel>>
}