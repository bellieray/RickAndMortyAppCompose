package com.ebelli.result

import retrofit2.Response

suspend fun <T> networkCall(response: suspend () -> Response<T>): NetworkResult<T> {
    val request = response()
    return if (request.isSuccessful) {
        NetworkResult.Success(request.body())
    } else {
        NetworkResult.Failed(request.errorBody()?.string())
    }
}

suspend fun <T> databaseCall(response: suspend () -> T): NetworkResult<T> {
    return try {
        NetworkResult.Success(response())
    } catch (e: Exception) {
        NetworkResult.Failed(e.localizedMessage)
    }
}