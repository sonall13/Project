package com.example.serene.Bottumnavigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.serene.Login.ForgetPasswordActivity
import com.example.serene.R

// TODO: Rename parameter arguments, choose names that match

class
ProfileFregment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile_fregment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val editTextFeedback: EditText = view.findViewById(R.id.editTextFeedback)
        val buttonSubmitFeedback: Button = view.findViewById(R.id.fb)
        val shareButton: Button = view.findViewById(R.id.shareButton)
        val changepass: Button = view.findViewById(R.id.changepass)
        changepass.setOnClickListener {
            var inte=Intent(context,ForgetPasswordActivity::class.java)
            startActivity(inte)
        }
        //share with friends

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
