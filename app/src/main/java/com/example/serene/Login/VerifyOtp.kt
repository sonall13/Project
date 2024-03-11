package com.example.serene.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifyOtp : AppCompatActivity() {

    lateinit var otpfield : TextInputEditText
    lateinit var verifyotp : Button
    lateinit var loading : ProgressBar
    lateinit var getemail : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_otp)

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