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
import com.example.serene.Home_page
import com.example.serene.Login.ForgetPasswordActivity
import com.example.serene.Login.Login_pae
import com.example.serene.R
import com.example.serene.SplaseScreen
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
        val editTextFeedback: EditText = view.findViewById(R.id.editTextFeedback)
        val buttonSubmitFeedback: Button = view.findViewById(R.id.fb)
        val Terms: TextView = view.findViewById(R.id.terms)
        val shareButton: TextView = view.findViewById(R.id.shareButton)
        val changepass: TextView = view.findViewById(R.id.changepass)
        val logouttext: TextView = view.findViewById(R.id.logouttext)

//
//        var value = Login_pae().intent.getStringExtra("setemail")
//        setemail.text = value.toString()

        logouttext.setOnClickListener {
            SplaseScreen.edit.putBoolean("status", false)
            SplaseScreen.edit.apply()
            startActivity(Intent(context,Login_pae::class.java))
            activity?.finish()

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

}

