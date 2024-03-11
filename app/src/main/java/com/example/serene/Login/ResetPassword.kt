package com.example.serene.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.Home_page
import com.example.serene.R
import com.example.serene.SplaseScreen
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResetPassword : AppCompatActivity() {

    lateinit var confirmpassword : TextInputEditText
    lateinit var ResetPassword : TextInputEditText
    lateinit var resetbtn : Button
    lateinit var process : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        confirmpassword =findViewById(R.id.confirmpassword)
        ResetPassword =findViewById(R.id.resetpassword)
        resetbtn =findViewById(R.id.resetbtn)
        process =findViewById(R.id.Process)

        var uidd = intent.getStringExtra("uid")
        var token = SplaseScreen.sp.getString("token"," ")

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

                                    token = uidd
                                    startActivity(Intent(this@ResetPassword, Home_page::class.java))
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