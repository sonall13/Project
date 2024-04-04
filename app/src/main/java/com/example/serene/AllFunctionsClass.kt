package com.example.serene

import android.os.Build
import androidx.core.content.ContextCompat.getColor

public class AllFunctionsClass {


     fun isValidEmail(email: String): Boolean {
        val emailRegex = "[a-z[0-9._-]]+@[gmail]+\\.+com"
        return email.matches(emailRegex.toRegex())
    }

     fun isValidPassword(password: String): Boolean {
        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
        return password.matches(passwordRegex.toRegex())
    }







}