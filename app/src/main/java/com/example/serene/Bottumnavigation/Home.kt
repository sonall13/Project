package com.example.serene.Bottumnavigation

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.serene.GetData.JournalingDataActivity
import com.example.serene.R
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.HorizontalCalendarListener
import devs.mulham.horizontalcalendar.HorizontalCalendarView
import java.text.DateFormat
import java.util.Date


class Home : Fragment() {

     lateinit var calendarView : HorizontalCalendarView
     lateinit var text : TextView
     lateinit var happy : ImageView
     lateinit var angry : ImageView
     lateinit var sick : ImageView
     lateinit var crying : ImageView
     lateinit var gretful : ImageView
     lateinit var stressed : ImageView
     lateinit var good : ImageView
     lateinit var notgreat : ImageView
     var array1 = ArrayList<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text = view.findViewById(R.id.text)
        happy = view.findViewById(R.id.happy)
        angry = view.findViewById(R.id.angry)
        sick = view.findViewById(R.id.sick)
        crying = view.findViewById(R.id.crying)
        gretful = view.findViewById(R.id.grateful)
        stressed = view.findViewById(R.id.stress)
        good = view.findViewById(R.id.good)
        notgreat = view.findViewById(R.id.notgreat)


        happy.setOnClickListener {
            Toast1()
        }
        angry.setOnClickListener {
            Toast1()
        }
        sick.setOnClickListener {
            Toast1()
        }
        crying.setOnClickListener {
            Toast1()
        }
        gretful.setOnClickListener {
            Toast1()
        }
        stressed.setOnClickListener {
            Toast1()
        }
        good.setOnClickListener {
            Toast1()
        }
        notgreat.setOnClickListener {
            Toast1()
        }

        array1.add("A healthy outside starts from the inside. - Robert Urich")
        array1.add("\"The groundwork of all happiness is health.\" - Leigh Hunt")
        array1.add("\"Happiness is the highest form of health.\" - Dalai Lama")
        array1.add("A healthy outside starts from the inside. - Robert Urich")
        array1.add("\"Happiness is the highest form of health.\" - Dalai Lama")
        array1.add("\"The groundwork of all happiness is health.\" - Leigh Hunt")

//        data1 = view.findViewById(R.id.data)
//
//        data1.setOnClickListener {
//
//            activity?.let{
//                val intent = Intent (it, JournalingDataActivity::class.java)
//                it.startActivity(intent)
//            }
//
//        }


        val startDate = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -1)

        val endDate = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)

        val horizontalCalendar: HorizontalCalendar =
            HorizontalCalendar.Builder(view, R.id.calendarView).startDate(startDate.time).endDate(endDate.time)
                .datesNumberOnScreen(5)
                .build()

        horizontalCalendar.
        calendarListener = object : HorizontalCalendarListener() {
            override fun onDateSelected(date: Date?, position: Int) {
                if (context != null) {

                }
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var f=inflater.inflate(R.layout.fragment_home, container, false)
        return f
    }
    fun Toast1(){
      Toast.makeText(context, "saved your Day! ", Toast.LENGTH_SHORT).show()
    }

}