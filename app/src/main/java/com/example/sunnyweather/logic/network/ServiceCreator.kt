package com.example.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    //不使用内联函数 泛型只会在编译期间有具体类型，运行期间类型将被擦除（基于JVM的语言都是如此--类型擦除机制）
    //泛型实化 1.该函数必须是内联函数 2.声明泛型的地方加上reified关键字，代码在编译之后会直接使用实际的类型
    // 来替代内联函数中泛型声明
    inline fun <reified T> create(): T = create(T::class.java)

    /**
     * 1.
     * val appService = retrofit.create(AppService::class.java)
     * 2.
     * fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
     * 3.
     * fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
     * inline fun <reified T> create(): T = create(T::class.java)
     */
}