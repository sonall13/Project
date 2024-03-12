package com.example.serene.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ProgressBar
import android.widget.ScrollView
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import com.example.serene.Signup.SignUp_page
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgetPasswordActivity : AppCompatActivity() {

    lateinit var emailfield : TextInputEditText
    lateinit var verify : Button
    lateinit var scrollView : ScrollView
    lateinit var progressBar : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        emailfield = findViewById(R.id.emailfield)
        verify = findViewById(R.id.verify)
        progressBar = findViewById(R.id.progressBar)
        scrollView=findViewById(R.id.scrollView)

        //scroll.................................

        scrollView .viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                // Check if the content size has changed
                val hasContentChanged = scrollView.childCount > 0 && scrollView.getChildAt(0).height != scrollView.height

                // Adjust the layout to avoid cutting off content when the keyboard is shown
                if (hasContentChanged) {
                    val heightDiff = scrollView.getChildAt(0).height - scrollView.height
                    if (heightDiff > 20) { // Arbitrary threshold to detect significant changes
                        scrollView.scrollTo(0, heightDiff)
                    }
                }

                return true
            }
        })

        verify.setOnClickListener {

            progressBar.visibility= View.VISIBLE

            RetrofitInstance().method().forgerpassword(emailfield.text.toString()).enqueue(object : Callback<ForgetpasswordData>  {
                override fun onResponse(
                    call: Call<ForgetpasswordData>?,
                    response: Response<ForgetpasswordData>?,
                ) {
                    Log.d("-=-=----", "onResponse: ${response!!.body()}")

                    if(response.body()?.status == "success"){
                        var otp= response.body()!!.otp

                        startActivity(Intent(this@ForgetPasswordActivity , VerifyOtp::class.java)
                            .putExtra("verifyemail",emailfield.text.toString())
                            .putExtra("otp",otp))
                    }

                }
                override fun onFailure(call: Call<ForgetpasswordData>?, t: Throwable?) {
                    Log.d("-=---===", "onFailure: ${t!!.localizedMessage}")
                }
            })
        }


    }
}