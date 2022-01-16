package com.hiteshchopra.ktorclientdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hiteshchopra.ktorclientdemo.ViewState.Loading
import com.hiteshchopra.ktorclientdemo.ViewState.Success
import com.hiteshchopra.ktorclientdemo.data.repo.ImagesRepo
import com.hiteshchopra.ktorclientdemo.data.repo.Result.Error
import com.hiteshchopra.ktorclientdemo.data.repo.Result.SuccessWithData
import kotlinx.coroutines.launch

class MainActivityVM : ViewModel() {

  private val imagesRepo: ImagesRepo = ImagesRepo()
  private val _fetchImagesViewState = MutableLiveData<ViewState>()
  val fetchImagesViewState: LiveData<ViewState> = _fetchImagesViewState

  fun fetchImages() {
    _fetchImagesViewState.value = Loading
    viewModelScope.launch {
      when (val response = imagesRepo.fetchImages()) {
        is SuccessWithData<*> -> {
          _fetchImagesViewState.value = Success(response.data)
        }
        is Error -> {
          _fetchImagesViewState.value =
            ViewState.Error(response.exception.message ?: "Something went wrong")
        }
      }
    }
  }
}

sealed class ViewState {
  object Loading : ViewState()
  class Success<T>(val data: T) : ViewState()
  class Error(val message: String) : ViewState()
}
