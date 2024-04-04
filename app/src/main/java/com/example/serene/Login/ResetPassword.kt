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
import android.widget.Toast
import com.example.serene.AllFunctionsClass
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.Home_page
import com.example.serene.R
import com.example.serene.SplaseScreen
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class ResetPassword : AppCompatActivity()  {

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
//        val passCheck = ResetPassword.text.toString().matches(Regex(SplaseScreen.pass)).toString()
//        Log.d("-=---=", "onResponse: ${passCheck.toString()}")


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

            var w=AllFunctionsClass()

            process.visibility= View.VISIBLE

            val password = ResetPassword.text.toString().trim()

            if (w.isValidPassword(password)) {

                if (ResetPassword.text.toString() == confirmpassword.text.toString()) {
                    if (uidd != null) {
                        RetrofitInstance().method()
                            .resetpassword(uidd.toString(), ResetPassword.text.toString())
                            .enqueue(object : Callback<ResetPassworddataClass> {
                                override fun onResponse(
                                    call: Call<ResetPassworddataClass>?,
                                    response: Response<ResetPassworddataClass>?,
                                ) {

                                    Log.d("-=---=", "onResponse: ${response!!.body()}")
                                    if (response.body()?.status == "success") {

//                              var a=  SplaseScreen.edit.putString("uid",uidd.toString())
//                                SplaseScreen.edit.apply()

                                        SplaseScreen.edit.putBoolean("status", true)
                                        SplaseScreen.edit.apply()
//                                SplaseScreen.sp.getString("token"," ")

                                        SplaseScreen.edit.putString("token", uidd.toString())
                                        SplaseScreen.edit.apply()

                                        startActivity(
                                            Intent(
                                                this@ResetPassword,
                                                Home_page::class.java
                                            )
                                        )

                                    }
                                }

                                override fun onFailure(
                                    call: Call<ResetPassworddataClass>?,
                                    t: Throwable?
                                ) {
                                    Log.d("====------=", "onFailure: ${t!!.localizedMessage}")
                                }
                            })
                    }
                }
                else{
                    process.visibility= View.INVISIBLE
                    Toast.makeText(this@ResetPassword, "Confirm password has to be same", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                process.visibility= View.INVISIBLE
                Toast.makeText(this@ResetPassword, "enter valid password", Toast.LENGTH_SHORT).show()
                Log.d("-=---=", "onResponse: ${password}")

            }
        }
    }
//    private fun isValidEmail(email: String): Boolean {
//        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
//        return email.matches(emailRegex.toRegex())
//    }
//    private fun isValidPassword(password: String): Boolean {
//        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
//        return password.matches(passwordRegex.toRegex())
//    }
}