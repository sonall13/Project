package com.example.serene.GetData

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.CalendarView
import android.widget.TextView
import com.example.serene.Apidata.RetrofitInstance
import com.example.serene.R
import com.example.serene.SplaseScreen
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class VerticalCalendar : AppCompatActivity() {
    lateinit var calendarView : CalendarView
    lateinit var dateTV : TextView
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
        setContentView(R.layout.activity_vertical_calendar)

        calendarView=findViewById(R.id.calendarView)
            dateTV=findViewById(R.id.dateTV)

       calendarView.setOnDateChangeListener { view, year, month, dayOfMonth, ->
           val clickedDate = formatDateForApi(year, month, dayOfMonth)
           fetchDataFromApi(clickedDate)

           val DateString = clickedDate
           val parsedDate = parseApiDate(DateString)
           val formattedDate = formatDateForCalendar(parsedDate)

           var z=SplaseScreen.edit.putString("formattedDate",formattedDate)
           SplaseScreen.edit.apply()
            println("Formatted Date: $formattedDate")
           startActivity(Intent(this@VerticalCalendar,JournalingDataActivity::class.java)
               .putExtra("formattedDate",formattedDate))

       }


//        calendarView
//            .setOnDateChangeListener(
//                CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
//                    // In this Listener we are getting values
//                    // such as year, month and day of month
//                    // on below line we are cre
   //                    +ating a variable
//                    // in which we are adding all the variables in it.
//                    val Date = (dayOfMonth.toString() + "-"
//                            + (month + 1) + "-" + year)
//
//                    // set this date in TextView for Display
//                    dateTV.setText(Date)
//                })

    }
    fun parseApiDate(apiDateString: String): Date {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())
        return dateFormat.parse(apiDateString)
    }
    private fun formatDateForApi(year: Int, month: Int, dayOfMonth: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
    fun formatDateForCalendar(date: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        return "$year-${month + 1}-$dayOfMonth" // Adjust month + 1 as Calendar month starts from 0
    }
    private fun fetchDataFromApi(date: String) {
        // Implement your API request here
        // Use the 'date' parameter to fetch data for the specific date
    }
}