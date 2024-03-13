package com.example.serene.Signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.Toast
import com.example.serene.Login.Login_pae
import com.example.serene.Home_page
import com.example.serene.R
import com.example.serene.Apidata.RetrofitInstance
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUp_page : AppCompatActivity() {

    lateinit var email : TextInputEditText
    lateinit var username : TextInputEditText
    lateinit var password : TextInputEditText
    lateinit var login : Button
    lateinit var signup : Button
    lateinit var pb : ProgressBar
    lateinit var scrollView : ScrollView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        email = findViewById(R.id.email)
        username = findViewById(R.id.username)
        password =findViewById(R.id.password)
        login = findViewById(R.id.login)
        signup = findViewById(R.id.signup)
        pb = findViewById(R.id.pb)
        scrollView=findViewById(R.id.scrollView)
        //scroll.................................

        scrollView .viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                // Check if the content size has changed
                val hasContentChanged = scrollView.childCount > 0 && scrollView.getChildAt(0).height != scrollView.height

                // Adjust the layout to avoid cutting off content when the keyboard is shown
                if (hasContentChanged) {
                    val heightDiff = scrollView.getChildAt(0).height - scrollView.height
                    if (heightDiff > 50) { // Arbitrary threshold to detect significant changes
                        scrollView.scrollTo(0, heightDiff)
                    }
                }

                return true
            }
        })
        signup.setOnClickListener {

            pb.visibility= View.VISIBLE

            RetrofitInstance().method().myname(username.text.toString(),email.text.toString(),
                password.text.toString()).
            enqueue(object : Callback<RegisterDataClass> {

                override fun onResponse(call: Call<RegisterDataClass>?, response: Response<RegisterDataClass>?) {
                    Log.d("---=-==", "onResponse: ${response!!.body()}")

                    pb.visibility= View.GONE
                    startActivity(Intent(this@SignUp_page, Login_pae::class.java))
                    finish()
                }

                override fun onFailure(call: Call<RegisterDataClass>?, t: Throwable?) {
                    Log.d("===----=", "onFailure: ${t!!.localizedMessage}")
                }
            })

        }
        login.setOnClickListener {

            startActivity(Intent(this@SignUp_page, Login_pae::class.java))
            finish()
        }

    }
}