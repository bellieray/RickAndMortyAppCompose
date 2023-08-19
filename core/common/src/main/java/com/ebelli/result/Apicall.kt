package com.ebelli.result

import retrofit2.Response

suspend fun <T> apiCall(response: suspend () -> Response<T>): NetworkResult<T> {
    val response = response()
    return if (response.isSuccessful) {
        NetworkResult.Success(response.body())
    } else {
        NetworkResult.Failed(response.code())
    }
}