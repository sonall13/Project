package com.example.serene.JournalingActivity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import com.example.serene.SplaseScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FreeStyle : AppCompatActivity() {

    lateinit var savefreestyle : Button
    lateinit var freestyletext : EditText
    lateinit var back : ImageButton
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
        setContentView(R.layout.activity_free_style)

        savefreestyle=findViewById(R.id.savefreestyle)
        freestyletext=findViewById(R.id.freestyletext)
        back=findViewById(R.id.back)

        savefreestyle.setOnClickListener {

            var token = SplaseScreen.sp.getString("token"," ")
            Log.d("=fs-token", "onCreate: ${token}")

            var data = FreeStyleDatatext(freestyletext.text.toString())
            Log.d("-data-", "onCreate: ${data}")

            RetrofitInstance().method().freestyle(token!!,data)
                .enqueue(object : Callback<FreeStyleDataClass> {
                    override fun onResponse(
                        call: Call<FreeStyleDataClass>,
                        response: Response<FreeStyleDataClass>,
                    ) {
                        Log.d("fs_response", "onResponse: ${response.body()}")
                        if(response.body()?.status == "success"){

                            Log.d("fs_status", "onResponse: data entered")
                            Toast.makeText(this@FreeStyle, "data entered", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<FreeStyleDataClass>, t: Throwable) {
                        Log.d("freestyle-fail", "onFailure: ${t.localizedMessage}")

                    }
                })
        }
        back.setOnClickListener {
            onBackPressed()
        }


    }
}