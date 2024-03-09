package com.example.serene.JournalingActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.Login.LoginDataClass
import com.example.serene.R
import org.json.JSONObject
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

    var map = HashMap<String,Any>()
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

            map.put("q1",seconanswer.text.toString())
            map.put("q2",multianswerarray)
            map.put("q3",thirdanswer.text.toString())

            var token = intent.getStringExtra("token")

            Log.d("======", "onCreate: ${map}")


            savemornign.setOnClickListener {

//                RetrofitInstance().journaling().create("mornign",map).

            }



        }


    }
}