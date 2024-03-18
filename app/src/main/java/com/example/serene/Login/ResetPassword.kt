package com.example.serene.Login

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ProgressBar
import android.widget.ScrollView
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.Home_page
import com.example.serene.R
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResetPassword : AppCompatActivity() {

    lateinit var confirmpassword : TextInputEditText
    lateinit var ResetPassword : TextInputEditText
    lateinit var resetbtn : Button
    lateinit var scrollView : ScrollView
    lateinit var process : ProgressBar

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
        setContentView(R.layout.activity_reset_password)

        confirmpassword =findViewById(R.id.confirmpassword)
        ResetPassword =findViewById(R.id.resetpassword)
        resetbtn =findViewById(R.id.resetbtn)
        process =findViewById(R.id.Process)
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

        var uidd = intent.getStringExtra("uid")

        resetbtn.setOnClickListener {

            if (uidd != null) {
                RetrofitInstance().method().resetpassword(uidd,ResetPassword.text.toString())
                    .enqueue(object : Callback<ResetPassworddataClass> {
                        override fun onResponse(
                            call: Call<ResetPassworddataClass>?,
                            response: Response<ResetPassworddataClass>?,
                        ) {

                            Log.d("-=---=", "onResponse: ${response!!.body()}")
                            if(response.body()?.status == "success"){

                                startActivity(Intent(this@ResetPassword,Home_page::class.java))

                            }
                        }
                        override fun onFailure(call: Call<ResetPassworddataClass>?, t: Throwable?) {
                            Log.d("====------=", "onFailure: ${t!!.localizedMessage}")
                        }
                    })
            }


        }

    }
}