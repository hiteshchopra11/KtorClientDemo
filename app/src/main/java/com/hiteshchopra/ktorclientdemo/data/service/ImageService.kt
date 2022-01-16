package com.hiteshchopra.ktorclientdemo.data.service

import com.hiteshchopra.ktorclientdemo.data.model.ImageResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.ExperimentalSerializationApi

interface ImageService {
  suspend fun getImages(): ImageResponse

  companion object {
    @ExperimentalSerializationApi fun create(): ImageService {
      return ImageServiceImpl(
        client = HttpClient(Android) {
          install(Logging)
          install(JsonFeature) {
            serializer = GsonSerializer() {
              setPrettyPrinting()
              disableHtmlEscaping()
            }
          }
        }
      )
    }
  }
}