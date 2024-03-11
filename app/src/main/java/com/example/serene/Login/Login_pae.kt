package com.example.serene.Login

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.example.serene.Home_page
import com.example.serene.R
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.Signup.SignUp_page
import com.example.serene.SplaseScreen
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login_pae : AppCompatActivity() {

     lateinit var emailEt : TextInputEditText
     private lateinit var passwordEt : TextInputEditText
     private lateinit var loginbtn : Button
     private lateinit var signupbtn : Button
     lateinit var pb : ProgressBar
     private lateinit var forgetbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_pae)

        emailEt = findViewById(R.id.emailEt)
        passwordEt =findViewById(R.id.passwordEt)
        loginbtn = findViewById(R.id.loginbtn)
        signupbtn = findViewById(R.id.signupbtn)
        pb = findViewById(R.id.progressBar)
        forgetbtn = findViewById(R.id.forgetbtn)

        loginbtn.setOnClickListener {

            pb.visibility= View.VISIBLE

//            var ab = 0
//            var select = RetrofitInstance()
//           var   data = select.method().login(emailEt.text.toString(),passwordEt.text.toString())
//
//            while ()
//            {
////                ab = data.getInt(0)
////                SplaseScreen.edit.putInt("id",ab)
//                SplaseScreen.edit.putBoolean("status",true)
//                SplaseScreen.edit.apply()
//                Log.e("L====", "onCreate: ${SplaseScreen.sp.getBoolean("status",false)}" )
//                startActivity(Intent(this@Login_pae ,Home_page::class.java))
//                finish()
//            }

            RetrofitInstance().method().login(emailEt.text.toString(),
                passwordEt.text.toString()).
            enqueue(object : Callback<LoginDataClass> {
                override fun onResponse(call: Call<LoginDataClass>?, response: Response<LoginDataClass>?) {
                    Log.d("==++", "onResponse: ${response!!.body()}")

                    if(response.body()?.status == "success") {

                        var dd = response.body()!!.token

                        SplaseScreen.edit.putString("token",dd.toString())
                        SplaseScreen.edit.apply()
                        Log.d("===", "onResponse: $dd ===")

                        if (response.body()!!.data.email.toString() == emailEt.text.toString() &&
                            response.body()!!.token == dd) {

                            pb.visibility= View.GONE

                            startActivity(Intent(this@Login_pae, Home_page::class.java).
                            putExtra("token" , dd.toString()))
                            finish()
                        }
                        else{
                            pb.visibility= View.GONE
                            Toast.makeText(this@Login_pae, "create Account", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@Login_pae,SignUp_page::class.java))

                        }
                        }
                    else {
                        pb.visibility= View.GONE
                        Log.d("-=-=", "onResponse: ${response.isSuccessful} ")
                        Toast.makeText(this@Login_pae, "wrong details", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                override fun onFailure(call: Call<LoginDataClass>?, t: Throwable?) {
                    Log.d("===----=", "onFailure: ${t!!.localizedMessage}")

                }
            })

        }
        signupbtn.setOnClickListener {
            startActivity(Intent(this@Login_pae, SignUp_page::class.java))
            finish()

        }
        forgetbtn.setOnClickListener {
            startActivity(Intent(this@Login_pae, ForgetPasswordActivity::class.java))
            finish()
        }
    }
}