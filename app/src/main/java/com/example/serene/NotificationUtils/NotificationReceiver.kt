package com.example.serene.NotificationUtils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.localnotificationdemo.Notifications

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Notification Shown", Toast.LENGTH_LONG).show()

        var name = intent.getStringExtra("name").toString()

        Notifications.showNotification(context, name)
    }

}