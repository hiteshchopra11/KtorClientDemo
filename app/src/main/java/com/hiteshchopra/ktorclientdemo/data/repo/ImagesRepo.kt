package com.hiteshchopra.ktorclientdemo.data.repo

import com.hiteshchopra.ktorclientdemo.data.service.ImageService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImagesRepo {
    suspend fun fetchImages(): Result {
        return withContext(Dispatchers.IO) {
            try {
                val result = ImageService.create().getImages()
                Result.SuccessWithData(result)
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }
    }
}

sealed class Result {
    class SuccessWithData<T>(val data: T) : Result()
    class Error(val exception: Exception) : Result()
}