package com.ebelli.result

sealed class NetworkResult<T> {
    class Success<T>(val data: T? = null) : NetworkResult<T>()
    class Failed<T>(val exception: String?) : NetworkResult<T>()
}