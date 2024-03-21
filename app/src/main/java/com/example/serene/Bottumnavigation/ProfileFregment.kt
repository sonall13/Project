package com.example.serene.Bottumnavigation

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Login.ForgetPasswordActivity
import com.example.serene.Login.Login_pae
import com.example.serene.R
import com.example.serene.Termsandconditions

class
ProfileFregment : Fragment() {

    private var selectedImage: Uri? = null
    val PICK_IMAGE_REQUEST = 1
    val READ_EXTERNAL_STORAGE_PERMISSION_CODE = 2
    lateinit var setprofile:ImageView
    lateinit var profileImageView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var a=inflater.inflate(R.layout.fragment_profile_fregment, container, false)

        return a

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       profileImageView =view.findViewById(R.id.  profileImageView)
        val editTextFeedback: EditText = view.findViewById(R.id.editTextFeedback)
        val buttonSubmitFeedback: Button = view.findViewById(R.id.fb)
        val Terms: TextView = view.findViewById(R.id.terms)
         setprofile = view.findViewById(R.id.setprofile)
       var setemail : TextView = view.findViewById(R.id.setemail)
        val shareButton: TextView = view.findViewById(R.id.shareButton)
        val changepass: TextView = view.findViewById(R.id.changepass)


//
//        var value = Login_pae().intent.getStringExtra("setemail")
//        setemail.text = value.toString()

        profileImageView.setOnClickListener {

            if (context?.let { it1 ->
                    ContextCompat.checkSelfPermission(
                        it1, android.Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                } != PackageManager.PERMISSION_GRANTED
            ) {
                openGallery()
            }
        }
        changepass.setOnClickListener {
            var inte=Intent(context,ForgetPasswordActivity::class.java)
            startActivity(inte)
        }
        //share with friends

        Terms.setOnClickListener {
         var inte=Intent(context,Termsandconditions::class.java)
            startActivity(inte)
        }
        shareButton.setOnClickListener {
            val appPackageName = "com.example.serene"
            val playStoreLink = "https://play.google.com/store/apps/details?id=$appPackageName"

            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Check out this cool app: $playStoreLink")
            }
            startActivity(Intent.createChooser(shareIntent, "Share with"))
        }

        // submit feedback

        buttonSubmitFeedback.setOnClickListener {
            val feedbackMessage = editTextFeedback.text.toString().trim()



            if (feedbackMessage.isNotEmpty()) {

                // Here, you can implement logic to send the feedback, e.g., to a server or database.
                // For demonstration purposes, we'll just display a toast.
                Toast.makeText(context, "Feedback submitted: $feedbackMessage", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(context, "Please enter your feedback", Toast.LENGTH_SHORT).show()
            }

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
                setprofile.setImageURI(selectedImage)
                Log.d("ppooopppppppp", "onActivityResult: ${selectedImage}")
                profileImageView.visibility = View.INVISIBLE
                setprofile.setOnClickListener {
                    openGallery()
                }
            }
        }
}

