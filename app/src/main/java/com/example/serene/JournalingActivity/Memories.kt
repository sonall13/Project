package com.example.serene.JournalingActivity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Memories : AppCompatActivity() {

    // One Preview Image
    lateinit var i1: ImageView
    lateinit var i2: ImageView
    lateinit var textarea: EditText
    lateinit var savememory: Button
    private val PICK_IMAGE_REQUEST = 1
    private val READ_EXTERNAL_STORAGE_PERMISSION_CODE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memories)


        i1 = findViewById(R.id.i1)
        i2 = findViewById(R.id.i2)
        textarea = findViewById(R.id.textarea)
        savememory = findViewById(R.id.savememory)

        i1.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                openGallery()
            }
        }

        savememory.setOnClickListener {

            RetrofitInstance().method().memory(textarea.text.toString(),i1)
                .enqueue(object : Callback<MemoryDataClass> {
                    override fun onResponse(
                        call: Call<MemoryDataClass>,
                        response: Response<MemoryDataClass>,
                    ) {
                        Log.d("-=-=-=----", "onResponse: ${response.body()}")

                    }
                    override fun onFailure(call: Call<MemoryDataClass>, t: Throwable) {
                        Log.d("++__", "onFailure: ${t.localizedMessage}")
                    }
                })


        }




    }

    private fun openGallery() {
        val galleryIntent =
            Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == READ_EXTERNAL_STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery()
            } else {
                // Permission denied
                // Handle accordingly (show a message, request again, etc.)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImage: Uri? = data.data
            // Set the selected image URI in the ImageView
            i2.setImageURI(selectedImage)
            i1.visibility = View.INVISIBLE
            i2.setOnClickListener {
                openGallery()
            }
            if (i2.visibility == View.VISIBLE) {
                // If the EditText is visible, hide it
                textarea.visibility = View.VISIBLE
            } else {
                // If the EditText is hidden, show it
                textarea.visibility = View.GONE
            }
        }

    }

}