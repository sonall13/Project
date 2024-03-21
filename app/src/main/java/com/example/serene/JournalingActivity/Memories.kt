package com.example.serene.JournalingActivity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import com.example.serene.SplaseScreen
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okio.BufferedSink
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream
import kotlin.io.encoding.ExperimentalEncodingApi


class Memories : AppCompatActivity() {

    private var selectedImage: Uri? = null

    // One Preview Image
    lateinit var i1: ImageView
    lateinit var back:ImageButton
    lateinit var i2: ImageView
    lateinit var textarea: EditText
    lateinit var savememory: Button
    private val PICK_IMAGE_REQUEST = 1
    private val READ_EXTERNAL_STORAGE_PERMISSION_CODE = 2

    @OptIn(ExperimentalEncodingApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make the activity fullscreen
//        window.requestFeature(Window.FEATURE_NO_TITLE)
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = getColor(R.color.statusbarcolor)
        }
        setContentView(R.layout.activity_memories)

        i1 = findViewById(R.id.i1)
        i2 = findViewById(R.id.i2)
        textarea = findViewById(R.id.textarea)
        savememory = findViewById(R.id.savememory)
        back = findViewById(R.id.back)
        Toast.makeText(this, "helloww..   What's your beautiful memory of the day :)  ", Toast.LENGTH_SHORT).show()

        back.setOnClickListener {
            onBackPressed()
        }
        i1.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    this, android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                openGallery()
            }
        }
        savememory.setOnClickListener {
            uploadImage()

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
    fun uploadImage() {

        Toast.makeText(this@Memories, "please wait", Toast.LENGTH_LONG).show()

        class UploadStreamRequestBody(
            private val mediaType: String,
            private val inputStream: InputStream,
            private val onUploadProgress: (Int) -> Unit,
        ) : RequestBody() {

            override fun contentLength(): Long = inputStream.available().toLong()

            override fun contentType(): MediaType? = MediaType.parse(mediaType)

            override fun writeTo(sink: BufferedSink) {

                val contentLength = inputStream.available().toFloat()
                val buffer =
                    ByteArray(DEFAULT_BUFFER_SIZE) // DEFAULT_BUFFER_SIZE constant from kotlin.io.ConstantsKt
                inputStream.use { inputStream ->
                    var uploaded = 0
                    var read: Int
                    while (inputStream.read(buffer)
                            .also { read = it } != -1
                    ) { // Reads the stream until the content ends
                        sink.write(buffer, 0, read)
                        uploaded += read
                        onUploadProgress((100 * uploaded / contentLength).toInt())
                    }
                }
            }
        }

        lifecycleScope.launch {

            val stream = contentResolver.openInputStream(selectedImage!!) ?: return@launch
            val request = UploadStreamRequestBody("image/*", stream, onUploadProgress = {
                Log.d("+++++++++P", "On upload progress $it")
            })
            val filePart = MultipartBody.Part.createFormData(
                "image",
                "test.jpg",
                request
            )

            var token = SplaseScreen.sp.getString("token" , "")

            var tokenInt =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY1ZjE0Y2E5Y2RhMmYwNDZhMDI2YjAwYiIsImlhdCI6MTcxMDQ3OTE5N30.5qzjI92IPIZm8ChaUeb_aVaPYU-MhfODKy8UB3vTqlk"

            var caption = RequestBody.create(MediaType.parse("multipart/form-data"), textarea.text.toString())

            RetrofitInstance().method().memory(token!!, caption, filePart)
                .enqueue(object : Callback<MemoryDataClass> {
                    override fun onResponse(
                        call: Call<MemoryDataClass>,
                        response: Response<MemoryDataClass>,
                    ) {

                        Log.d("++++++++++R", "onResponse: ${response}")
                        Log.d("++++++++++R", "onResponse: ${response.body()}")
                        if (response.body()?.status == "success") {
                            Toast.makeText(this@Memories, "Data entered", Toast.LENGTH_SHORT).show()
                            Log.d("=g-status=", "onResponse: data entered")
                        } else {

                        }
                    }
                    override fun onFailure(call: Call<MemoryDataClass>, t: Throwable) {
                        Log.d("+++++++E", "onFailure: ${t.localizedMessage}")
                    }
                })
        }
    }

}