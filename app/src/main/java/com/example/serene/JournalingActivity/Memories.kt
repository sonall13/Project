package com.example.serene.JournalingActivity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import kotlin.io.encoding.ExperimentalEncodingApi


class Memories : AppCompatActivity() {

    private var selectedImage: Uri? = null

    // One Preview Image
    lateinit var i1: ImageView
    lateinit var i2: ImageView
    lateinit var textarea: EditText
    lateinit var savememory: Button
    private val PICK_IMAGE_REQUEST = 1
    private val READ_EXTERNAL_STORAGE_PERMISSION_CODE = 2

    @OptIn(ExperimentalEncodingApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memories)

        i1 = findViewById(R.id.i1)
        i2 = findViewById(R.id.i2)
        textarea = findViewById(R.id.textarea)
        savememory = findViewById(R.id.savememory)

        i1.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    this, android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                openGallery()
            }
        }
        savememory.setOnClickListener {

            val bitmap = (i2.getDrawable() as BitmapDrawable).bitmap
            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val imageInByte = baos.toByteArray()
            var sImage = Base64.encodeToString(imageInByte, Base64.DEFAULT);

//            Log.d("imgeeee", "onCreate: ${imageInByte.toString()}")

            /* var token = SplaseScreen.sp.getString("token", " ")
             Log.d("=memory-token", "onCreate: ${token}")*/

            var dataa = Mymemories(textarea.text.toString(), i2.drawable.toString())
            //Log.d("===dataa===", "onCreate: ${sImage}")

            //pass it like this
            //pass it like this
            val file = File("/storage/emulated/0/Download/5.png")
            val requestFile = RequestBody.create(MultipartBody.FORM, imageInByte)

// MultipartBody.Part is used to send also the actual file name
            val body = MultipartBody.Part.createFormData("image", file.name, requestFile)

// add another part within the multipart request
            val fullName = RequestBody.create(MultipartBody.FORM, "Your Name")

            val map: MutableMap<String, RequestBody> = HashMap()
            map["caption"] = fullName
            map["image"] = requestFile

            var tokenInt =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY1ZjE0Y2E5Y2RhMmYwNDZhMDI2YjAwYiIsImlhdCI6MTcxMDQ3OTE5N30.5qzjI92IPIZm8ChaUeb_aVaPYU-MhfODKy8UB3vTqlk"

            RetrofitInstance().method().memory(tokenInt, map)
                .enqueue(object : Callback<MemoryDataClass> {
                    override fun onResponse(
                        call: Call<MemoryDataClass>,
                        response: Response<MemoryDataClass>,
                    ) {
                        Log.d("=======R", "onResponse: ${response.body()}")
                        if (response.body()?.status == "success") {

                            Log.d("=g-status=", "onResponse: data entered")
                            Toast.makeText(this@Memories, "data entered", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<MemoryDataClass>, t: Throwable) {
                        Log.d("=======E", "onFailure: ${t.localizedMessage}")
                    }
                })
        }
    }

    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
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
            selectedImage = data.data
            // Set the selected image URI in the ImageView
            i2.setImageURI(selectedImage)
            Log.d("ppooopppppppp", "onActivityResult: ${selectedImage}")
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