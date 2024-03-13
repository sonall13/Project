package com.example.serene.Bottumnavigation

import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.serene.R
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.HorizontalCalendarListener
import devs.mulham.horizontalcalendar.HorizontalCalendarView
import java.text.DateFormat
import java.util.Date


class Home : Fragment() {

     lateinit var calendarView : HorizontalCalendarView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val startDate = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -1)

        val endDate = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)

        val horizontalCalendar: HorizontalCalendar =
            HorizontalCalendar.Builder(view, R.id.calendarView).startDate(startDate.time).endDate(endDate.time)
                .datesNumberOnScreen(5)
                .build()


        horizontalCalendar.setCalendarListener(object : HorizontalCalendarListener() {
            override fun onDateSelected(date: Date?, position: Int) {
                if (context != null) {
                    Toast.makeText(
                        context!!,
                        " is selected!${DateFormat.getDateInstance().format(date)}",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }
        })

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var f=inflater.inflate(R.layout.fragment_home, container, false)


        return f
    }

}