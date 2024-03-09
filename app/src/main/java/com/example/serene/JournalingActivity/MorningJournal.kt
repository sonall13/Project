package com.example.serene.JournalingActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import com.example.serene.SplaseScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MorningJournal : AppCompatActivity() {

    private lateinit var multianswer1 : EditText
    private lateinit var multianswer2 : EditText
    private lateinit var multianswer3 : EditText
    private lateinit var seconanswer : EditText
    private lateinit var thirdanswer : EditText
    private lateinit var savemornign : Button

        private var multianswerarray = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morning_journal)

        multianswer1 = findViewById(R.id.multianswer1)
        multianswer2 = findViewById(R.id.multianswer2)
        multianswer3 = findViewById(R.id.multianswer3)
        seconanswer = findViewById(R.id.secondanswer)
        thirdanswer = findViewById(R.id.thirdanswer)
        savemornign = findViewById(R.id.savemornign)

        savemornign.setOnClickListener {

            multianswerarray.add(multianswer1.text.toString())
            multianswerarray.add(multianswer2.text.toString())
            multianswerarray.add(multianswer3.text.toString())

            var token = SplaseScreen.sp.getString("token"," ")
            Log.d("=m-token", "onCreate: ${token}")

            var modelclass = Answers(seconanswer.text.toString(),multianswerarray,thirdanswer.text.toString())
            var dataaa = MyData("morning",modelclass)
            Log.d("=m-dataa=", "onCreate: ${dataaa}")

            RetrofitInstance().method().create(token!!,dataaa)
                .enqueue(object : Callback<JournalingCreateDataClass> {
                    override fun onResponse(
                        call: Call<JournalingCreateDataClass>,
                        response: Response<JournalingCreateDataClass>,
                    ) {
                        Log.d("=m-response=", "onResponse: ${response.body()}")

                        if(response.body()?.status == "success"){

                            Log.d("=m-status=", "onResponse: data entered")
                            Toast.makeText(this@MorningJournal, "data entered", Toast.LENGTH_SHORT).show()

                        }
                    }
                    override fun onFailure(call: Call<JournalingCreateDataClass>, t: Throwable) {
                        Log.d("=m-fail=", "onFailure: ${t.localizedMessage}")
                    }
                })


        }


    }
}