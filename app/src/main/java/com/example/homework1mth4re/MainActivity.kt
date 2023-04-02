package com.example.homework1mth4re

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1mth4re.adapter.ImageAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var imageRecyclerView: RecyclerView
    private lateinit var selectedImagesRecyclerView: RecyclerView
    private lateinit var imageAdapter: ImageAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageRecyclerView = findViewById(R.id.imageRecyclerView)
        selectedImagesRecyclerView = findViewById(R.id.selectedImagesRecyclerView)

        val images = listOf(
            ContextCompat.getDrawable(this, R.drawable.image1)!!,
            ContextCompat.getDrawable(this, R.drawable.image1)!!,
            ContextCompat.getDrawable(this, R.drawable.image3)!!,
            ContextCompat.getDrawable(this, R.drawable.image4)!!
        )

        imageAdapter = ImageAdapter(images)
        imageRecyclerView.adapter = imageAdapter

        val selectedImagesAdapter = ImageAdapter(emptyList())
        selectedImagesRecyclerView.adapter = selectedImagesAdapter
    }
}