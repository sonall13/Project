package com.example.localnotificationdemo

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.serene.NotificationUtils.AlarmReceiver
import com.example.serene.R
import com.example.serene.SplaseScreen
import java.util.Calendar
import java.util.TimeZone
import java.util.concurrent.Executors

object Notifications {
    private const val NOTIFICATION_CHANNEL_ID = "TASK_NOTIFICATION_CHANNEL"

    @SuppressLint("MissingPermission")
    fun showNotification(context: Context, contentText: String) {
        Executors.newSingleThreadExecutor().execute {

            val openMainActivity = Intent(context, SplaseScreen::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            val notificationClickIntent = PendingIntent.getActivity(
                context,
                0,
                openMainActivity,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            val notification = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ad4)
                .setContentTitle("Test")
                .setContentText("this notification called by $contentText time")
                .setContentIntent(notificationClickIntent)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build()

            NotificationManagerCompat.from(context).notify(0, notification)
        }
    }

    @JvmStatic
    fun cancelNotification(context: Context, taskId: Long) {
        NotificationManagerCompat.from(context).cancel(taskId.toInt())
    }

    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.notification_channel_name)
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                name,
                NotificationManager.IMPORTANCE_HIGH
            )
            NotificationManagerCompat.from(context).createNotificationChannel(notificationChannel)
        }
    }


    /**************************************************************/
    /********************  Set Notification  **********************/
    /**************************************************************/

    fun setDailyNotificationAlarm(context: Context, hour: Int, minute: Int, second: Int, id: Int) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        val intent = Intent(context, NotificationReceiver::class.java)
        val intent = Intent(context, AlarmReceiver::class.java)
        intent.putExtra("name", "$hour:$minute")
        val broadcast = PendingIntent.getBroadcast(
            context,
            id,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val calendar: Calendar = Calendar.getInstance(TimeZone.getDefault()).apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, second)
        }
        //alarmManager[AlarmManager.RTC, calendar.timeInMillis] = broadcast

        // If the trigger time you specify is in the past, the alarm triggers immediately.
        // if soo just add one day to required calendar
        // Note: i'm also adding one min cuz if the user clicked on the notification as soon as
        // he receive it it will reschedule the alarm to fire another notification immediately
        if (Calendar.getInstance(TimeZone.getDefault()).timeInMillis - calendar.timeInMillis > 0
        ) {
            calendar.add(Calendar.DATE, 1)
        }

        alarmManager.setRepeating(
            AlarmManager.RTC,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            broadcast
        )

        //Toast.makeText(context, "Notification set successfully", Toast.LENGTH_LONG).show()
    }

    private const val ACTION_SHOW_NOTIFICATION = "ACTION_SHOW_NOTIFICATION"

    @SuppressLint("ScheduleExactAlarm")
    fun setNotificationAlarm(context: Context, hour: Comparable<*>, minute: Int, second: Int, id: Int) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //val intent = Intent(context, NotificationReceiver::class.java)
        val intent = Intent(context, AlarmReceiver::class.java)
//        intent.putExtra("name", "${zonedDateTime.hour}:${zonedDateTime.minute}")
//        intent.action = ACTION_SHOW_NOTIFICATION
        val broadcast = PendingIntent.getBroadcast(
            context,
            id,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val calendar: Calendar = Calendar.getInstance(TimeZone.getDefault()).apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, second)
        }
        //alarmManager[AlarmManager.RTC, calendar.timeInMillis] = broadcast
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), broadcast);

        //Toast.makeText(context, "Notification set successfully", Toast.LENGTH_LONG).show()

    }

    private fun set(hourOfDay: Int, hour: Comparable<*>) {


    }

}