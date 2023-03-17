package com.example.a20230310_carloscabrera_nycschools.tools


sealed class ResponseState<out T> {
    object LOADING: ResponseState<Nothing>()
    data class SUCCESS<T>(val response: T): ResponseState<T>()
    data class ERROR(val error: Exception): ResponseState<Nothing>()
}