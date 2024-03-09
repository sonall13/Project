package com.example.serene.sleepHome

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.serene.R

class BedtimeGoal : AppCompatActivity() {

    private lateinit var timePicker:TimePicker
    private lateinit var setreminder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bedtime_goal)


        timePicker = findViewById(R.id.timePicker1)
        setreminder = findViewById(R.id.sett)
        setContentView(R.layout.activity_bedtime_goal)



// Create a notification channel (required for Android 8.0 Oreo and above)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "your_channel_id"
            val channelName = "Your Channel Name"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance)
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
        val notificationId = 1
        val channelId = "your_channel_id"

// Create an intent to open when the notification is clicked
        val intent = Intent(this@BedtimeGoal, BedtimeGoal::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

// Build the notification
        val builder = NotificationCompat.Builder(this, channelId)
            .setContentTitle("It's your SERENE")
            .setContentText("hellowwww  !!    time for your sleep  take a good nap Good night")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setSmallIcon(R.drawable.blue)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

// Show the notification

        with(NotificationManagerCompat.from(this@BedtimeGoal)) {
            if (ActivityCompat.checkSelfPermission(
                    this@BedtimeGoal,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(notificationId, builder.build())
        }

    }
}