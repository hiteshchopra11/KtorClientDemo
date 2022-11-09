package com.hiteshchopra.ktorclientdemo.data.service

import com.hiteshchopra.ktorclientdemo.data.model.ImageResponse
import io.ktor.client.HttpClient
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

interface ImageService {
    suspend fun getImages(): ImageResponse

    companion object {
        fun create(): ImageService {
            return ImageServiceImpl(
                client = HttpClient(Android) {
                    install(Logging)
                    install(ContentNegotiation) {
                        gson()
                    }
                }
            )
        }
    }
}