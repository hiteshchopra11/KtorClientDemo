package com.hiteshchopra.ktorclientdemo.data.service

import com.hiteshchopra.ktorclientdemo.BuildConfig
import com.hiteshchopra.ktorclientdemo.data.HttpRoutes
import com.hiteshchopra.ktorclientdemo.data.model.ImageResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders

class ImageServiceImpl(
  private val client: HttpClient
) : ImageService {
  override suspend fun getImages(): ImageResponse {
    return client.get {
      headers {
        append(HttpHeaders.Authorization, "Client-ID ${BuildConfig.CLIENT_ID}")
      }
      url(HttpRoutes.FETCH_IMAGES_URL)
    }
  }
}