package com.example.serene.Login

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import com.chaos.view.PinView
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifyOtp : AppCompatActivity() {

    lateinit var otpfield : PinView
    lateinit var verifyotp : Button
    lateinit var loading : ProgressBar
    lateinit var getemail : TextView
    lateinit var scrollView:ScrollView
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
        setContentView(R.layout.activity_verify_otp)
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

//            ......................................

        otpfield = findViewById(R.id.otpfield)
        verifyotp = findViewById(R.id.verifyotp)
        loading = findViewById(R.id.loading)
        getemail = findViewById(R.id.getemail)

        var a=intent.getStringExtra("verifyemail")
        var otp=intent.getStringExtra("otp")

       getemail.setText(a)


        verifyotp.setOnClickListener {

            loading.visibility= View.VISIBLE

            Log.d("--======", "onCreate: ${a.toString()}")

            RetrofitInstance().method().verifyotp(a.toString(),otpfield.text.toString()).
                    enqueue(object : Callback<VerifyotpdataClass> {
                        override fun onResponse(
                            call: Call<VerifyotpdataClass>?,
                            response: Response<VerifyotpdataClass>?,
                        ) {

                            Log.d("++_+_", "onResponse: ${response!!.body()}")

                            if(response.body()?.status == "success") {

                                Log.d("+xcfdsf+_+_", "onResponse: ${response!!.body()!!.status}")
                                var uid = response.body()!!.uid

                                if (otp == otpfield.text.toString())
                            startActivity(
                                Intent(
                                    this@VerifyOtp,
                                    ResetPassword::class.java
                                ).putExtra("uid", uid)
                            )
                    }
                       }
                        override fun onFailure(call: Call<VerifyotpdataClass>?, t: Throwable?) {
                    Log.d("-=-=-=", "onFailure: ${t!!.localizedMessage}")
                        }
                    })

        }

    }
}