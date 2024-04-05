package com.example.serene.NotificationUtils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Handler
import android.os.Looper
import android.os.Vibrator
import android.widget.Toast
import com.example.serene.sleepHome.Alarm
import com.example.serene.sleepHome.Dismiss

class AlarmReceiver : BroadcastReceiver() {

    companion object {
        lateinit var ringtone: Ringtone
    }

    override fun onReceive(context: Context, intent: Intent) {

        // Initialize vibrator
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        //vibrator.vibrate(4000) // Uncomment this line to enable vibration

        // Show toast for alarm
        // Get default alarm ringtone URI
        var alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }

        // Create ringtone from URI
        ringtone = RingtoneManager.getRingtone(context, alarmUri)

        // Play ringtone
        ringtone.play()

        // Stop ringtone after 5 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            ringtone.stop()
        }, 10000)

        // Start Alarm activity
        val i = Intent(context, Dismiss::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(i)
    }
}
