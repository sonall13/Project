package com.example.serene.sleepHome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import com.example.serene.NotificationUtils.AlarmReceiver
import com.example.serene.R

class Dismiss : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dismiss)
        setDismissClickListener()
    }

    fun setDismissClickListener() {
        val buttonDismiss = findViewById<Button>(R.id.buttonDismiss)
        buttonDismiss.setOnClickListener {
            // Dismiss the alarm here
            AlarmReceiver.ringtone.stop()
            finish()
            Toast.makeText(this, "Alarm dismissed", Toast.LENGTH_SHORT).show()
        }
    }
}
