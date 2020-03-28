package com.example.practice.callback
interface ItemClickListener<T> {
    fun onClick(item : T)
}