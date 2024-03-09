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
import android.widget.Button
import android.widget.ProgressBar
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        email = findViewById(R.id.email)
        username = findViewById(R.id.username)
        password =findViewById(R.id.password)
        login = findViewById(R.id.login)
        signup = findViewById(R.id.signup)
        pb = findViewById(R.id.pb)

//
//        // Perform validation using a TextWatcher
//        email.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                // Not needed for this example
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                // Not needed for this example
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                val email = s.toString().trim()
//                if (TextUtils.isEmpty(email) || !isValidEmail(email)) {
////                    email.error = "Please enter a valid email address"
//
//                }
//            }
//        })


        // password velidation
        // Perform validation using a TextWatcher
//        password.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                // Not needed for this example
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                // Not needed for this example
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                var password = s.toString().trim()
//                if (TextUtils.isEmpty(password) || !isValidPassword(password)) {
////                    password.error = "Please enter a valid password"
//                    Toast.makeText(this@SignUp_page, "Please enter a valid password", Toast.LENGTH_SHORT).show()
//                }
//            }
//        })


        signup.setOnClickListener {

            pb.visibility= View.VISIBLE

            RetrofitInstance().method().myname("abcdefg",username.text.toString(),email.text.toString(),
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

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        // Add your password validation rules here
        // Example: At least 8 characters with at least one uppercase letter, one lowercase letter, and one digit
        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}\$"
        return password.matches(passwordRegex.toRegex())
    }
}