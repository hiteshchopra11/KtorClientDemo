package com.hiteshchopra.ktorclientdemo.data.model

import com.google.gson.annotations.SerializedName

class ImageResponse : ArrayList<ImageResponseItem>()

data class ImageResponseItem(
  @SerializedName("blur_hash")
  val blurHash: String?,
  @SerializedName("color")
  val color: String?,
  @SerializedName("created_at")
  val createdAt: String?,
  @SerializedName("current_user_collections")
  val currentUserCollections: Any?,
  @SerializedName("description")
  val description: String?,
  @SerializedName("height")
  val height: Int?,
  @SerializedName("id")
  val id: String?,
  @SerializedName("liked_by_user")
  val likedByUser: Boolean?,
  @SerializedName("likes")
  val likes: Int?,
  @SerializedName("links")
  val links: Any?,
  @SerializedName("updated_at")
  val updatedAt: String?,
  @SerializedName("urls")
  val urls: Urls?,
  @SerializedName("user")
  val user: Any?,
  @SerializedName("width")
  val width: Int?
)

data class Urls(
  @SerializedName("full")
  val full: String?,
  @SerializedName("raw")
  val raw: String?,
  @SerializedName("regular")
  val regular: String?,
  @SerializedName("small")
  val small: String?,
  @SerializedName("thumb")
  val thumb: String?
)