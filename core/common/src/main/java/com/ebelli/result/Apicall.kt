package com.ebelli.result

import retrofit2.Response

suspend fun <T> apiCall(response: suspend () -> Response<T>): NetworkResult<T> {
    val request = response()
    return if (request.isSuccessful) {
        NetworkResult.Success(request.body())
    } else {
        NetworkResult.Failed(request.code())
    }
}