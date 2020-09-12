package com.example.sunnyweather

import android.content.Context
import android.content.Intent

class Kotlin_Util {
    //泛型实化+高阶函数
    inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
        val intent = Intent(context, T::class.java)
        intent.block()
        context.startActivity(intent)
    }
}