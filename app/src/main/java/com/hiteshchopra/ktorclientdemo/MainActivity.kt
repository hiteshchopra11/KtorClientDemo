package com.hiteshchopra.ktorclientdemo

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiteshchopra.ktorclientdemo.ViewState.Error
import com.hiteshchopra.ktorclientdemo.ViewState.Loading
import com.hiteshchopra.ktorclientdemo.ViewState.Success
import com.hiteshchopra.ktorclientdemo.data.model.ImageResponse

class MainActivity : AppCompatActivity() {
  private val viewModel: MainActivityVM by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initUI()
    addObservers()
  }

  private fun initUI() {
    viewModel.fetchImages()
  }

  private fun addObservers() {
    viewModel.fetchImagesViewState.observe(this) { viewState ->
      when (viewState) {
        is Error -> {
          showProgressBar(false)
          Toast.makeText(this, viewState.message, Toast.LENGTH_SHORT).show()
        }
        is Loading -> {
          showProgressBar(true)
        }
        is Success<*> -> {
          showProgressBar(false)
          showUI(viewState.data as ImageResponse)
        }
      }
    }
  }

  private fun showUI(imageResponse: ImageResponse) {
    val recycleView = findViewById<RecyclerView>(R.id.rv_images)
    val imagesAdapter = ImagesAdapter(imageResponse)
    val layoutManager = LinearLayoutManager(this)
    recycleView.layoutManager = layoutManager
    recycleView.adapter = imagesAdapter
  }

  private fun showProgressBar(visible: Boolean) {
    val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
    progressBar.visibility = if (visible) View.VISIBLE else View.GONE
  }
}