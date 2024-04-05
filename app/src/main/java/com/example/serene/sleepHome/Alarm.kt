package com.example.serene.sleepHome

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import com.example.localnotificationdemo.Notifications
import com.example.serene.R
import com.example.serene.NotificationUtils.AlarmReceiver

class Alarm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make the activity fullscreen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = getColor(R.color.statusbarcolor)
        }
        setContentView(R.layout.activity_alarm)
        onClickTime()
        setAlarmClickListener()


    }

    private fun onClickTime() {
        val textView = findViewById<TextView>(R.id.textView)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        timePicker.setOnTimeChangedListener { _, hour, minute ->
            var hour = hour
            var am_pm = ""
            // AM_PM decider logic
            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM"
                }

                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM"
                }

                else -> am_pm = "AM"
            }
            if (textView != null) {
                val hourStr = if (hour < 10) "0$hour" else hour.toString()
                val minStr = if (minute < 10) "0$minute" else minute.toString()
                // display format of time
                val msg = "Time is: $hourStr : $minStr $am_pm"
                textView.text = msg
                textView.visibility = ViewGroup.VISIBLE
            }
        }
    }

    private fun setAlarmClickListener() {
        val buttonAlarm = findViewById<Button>(R.id.buttonAlarm)
        buttonAlarm.setOnClickListener {
            // Get the selected hour and minute from TimePicker
            val timePicker = findViewById<TimePicker>(R.id.timePicker)
            val hour = timePicker.hour
            val minute = timePicker.minute

            // Set the alarm using the Notifications utility class
            Notifications.createNotificationChannel(this)
            Notifications.setNotificationAlarm(this, hour, minute, 0, 0)
            Notifications.setDailyNotificationAlarm(this, 20, 46, 0, 1)

            // Show a toast message or perform any other action to indicate that the alarm is set
            Toast.makeText(this, "Alarm set for $hour:$minute", Toast.LENGTH_SHORT).show()
        }
    }


    }

