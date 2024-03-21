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

class Gratitude : AppCompatActivity() {

    lateinit var savegratitude : Button
    lateinit var multianswer1 : EditText
    lateinit var multianswer2 : EditText
    lateinit var multianswer3 : EditText
    lateinit var firstanswer : EditText
    lateinit var thirdanswer : EditText
    lateinit var back : ImageButton
    lateinit var save:Button

    var multianswerarray = ArrayList<String>()
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
        setContentView(R.layout.activity_gratitude)


        savegratitude=findViewById(R.id.savegratitude)
        back=findViewById(R.id.back)
        multianswer1=findViewById(R.id.multianswer1)
        multianswer2=findViewById(R.id.multianswer2)
        multianswer3=findViewById(R.id.multianswer3)
        thirdanswer=findViewById(R.id.thirdanswer)
        firstanswer=findViewById(R.id.firstanswer)

        savegratitude.setOnClickListener {

            multianswerarray.add(multianswer1.text.toString())
            multianswerarray.add(multianswer2.text.toString())
            multianswerarray.add(multianswer3.text.toString())

            var token = SplaseScreen.sp.getString("token"," ")
            Log.d("=g-token", "onCreate: ${token}")

            var modelclass = Answers(multianswerarray,firstanswer.text.toString(),thirdanswer.text.toString())
            var dataa = MyData("gratitude",modelclass)
            Log.d("===dataa===", "onCreate: ${dataa}")

            RetrofitInstance().method().create(token!!,dataa)
                .enqueue(object : Callback<JournalingCreateDataClass> {
                    override fun onResponse(
                        call: Call<JournalingCreateDataClass>,
                        response: Response<JournalingCreateDataClass>,
                    ) {
                        Log.d("=responce-gratitude=", "onResponse: ${response.body()}")

                        if(response.body()?.status == "success"){

                            Log.d("=g-status=", "onResponse: data entered")
                            Toast.makeText(this@Gratitude, "data entered", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<JournalingCreateDataClass>, t: Throwable) {
                        Log.d("=gratitude-fail=", "onFailure: ${t.localizedMessage}")
                    }
                })


        }
        back.setOnClickListener {
            onBackPressed()
        }


    }
}